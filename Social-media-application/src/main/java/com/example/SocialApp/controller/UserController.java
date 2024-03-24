package com.example.SocialApp.controller;

import com.example.SocialApp.models.User;
import com.example.SocialApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addPost(@RequestBody User user){
        try{
            return userService.addUser(user);
        }
        catch (Exception e) {
            return  e.getMessage();
        }

    }
}
