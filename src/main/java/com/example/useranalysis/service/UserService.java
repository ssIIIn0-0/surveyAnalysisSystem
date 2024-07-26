package com.example.useranalysis.service;

import com.example.useranalysis.model.User;
import com.example.useranalysis.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private JsonNode titles;

    public UserService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        titles = mapper.readTree(new ClassPathResource("titles.json").getInputStream());
    }

    public User analyzeAndSaveUser(Long userid, boolean[] answers) {
        String type1 = determineType(new int[]{0, 1, 2}, answers, "유동적", "계획적");
        String type2 = determineType(new int[]{2, 3, 4}, answers, "플렉스", "가성비");
        String type3 = answers[5] ? "현지인 체험" : "유명 관광지";
        String type4 = answers[6] ? "혼자" : "다같이";

        String title = titles.path(type1)
                .path(type2)
                .path(type3)
                .path(type4)
                .asText();

        Optional<User> userOptional = userRepository.findById(userid);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setTitle(title);
            return userRepository.save(user);
        }else{
            throw new RuntimeException("User not found with id : " + userid);
        }
    }

    private String determineType(int[] questionIndices, boolean[] answers, String option1, String option2) {
        int countOption1 = 0;
        int countOption2 = 0;

        for (int index : questionIndices) {
            if (answers[index]) {
                countOption1++;
            } else {
                countOption2++;
            }
        }

        return countOption1 >= 2 ? option1 : option2;
    }
}