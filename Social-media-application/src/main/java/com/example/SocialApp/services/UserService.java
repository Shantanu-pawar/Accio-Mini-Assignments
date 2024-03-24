package com.example.SocialApp.services;

import com.example.SocialApp.models.User;
import com.example.SocialApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        userRepository.save(user);
        return "user added";
    }


}
