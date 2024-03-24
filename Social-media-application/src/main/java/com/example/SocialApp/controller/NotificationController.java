package com.example.SocialApp.controller;

import com.example.SocialApp.DTOs.SendPostNotification;
import com.example.SocialApp.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping("/sendNotification")
    //POST API - Send a notification each time when  post is liked.

    public String addNotification(@RequestBody SendPostNotification sendPostNotification){
        try{
            return notificationService.addNotification(sendPostNotification);
        }catch (Exception e){
          return e.getMessage();
        }
    }
}
