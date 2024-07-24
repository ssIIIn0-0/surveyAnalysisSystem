package com.example.useranalysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.useranalysis.model.User;
import com.example.useranalysis.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/analyze/{userid}")
    public User analyzeUser(@PathVariable Long userid, @RequestBody boolean[] answers) {
        return userService.analyzeAndSaveUser(userid, answers);
    }
}
