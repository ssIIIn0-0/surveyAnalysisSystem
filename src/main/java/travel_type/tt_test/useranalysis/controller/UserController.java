package travel_type.tt_test.useranalysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel_type.tt_test.useranalysis.model.User;
import travel_type.tt_test.useranalysis.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/analyze")
    public User analyzeUser(@RequestBody User user) {
        return userService.analyzeAndSaveUser(user);
    }
}
