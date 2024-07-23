package travel_type.tt_test.useranalysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel_type.tt_test.useranalysis.model.User;
import travel_type.tt_test.useranalysis.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 칭호 저장
    public User analyzeAndSaveUser(User user) {
        String title = analyzeUser(user);
        user.setTitle(title);
        return userRepository.save(user);
    }

    // 분석 알고리즘 구현
    private String analyzeUser(User user) {
        if (user.isLikesQuietPlaces() && user.isLikesDesserts() && user.isLikesCoolPlaces() && !user.isLikesNature()){
            return "차가운 도시의 디저트 모험가";
        }
        return "초보 모험가";
    }
}
