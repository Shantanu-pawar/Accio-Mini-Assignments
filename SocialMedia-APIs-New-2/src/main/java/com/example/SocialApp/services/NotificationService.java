package com.example.SocialApp.services;

import com.example.SocialApp.DTOs.SendPostNotification;
import com.example.SocialApp.models.Notification;
import com.example.SocialApp.models.Post;
import com.example.SocialApp.models.User;
import com.example.SocialApp.repository.NotificationRepo;
import com.example.SocialApp.repository.PostRepo;
import com.example.SocialApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired NotificationRepo notificationRepo;
    @Autowired PostRepo postRepo;
    @Autowired UserRepository userRepository;

    // api - send notification to user when post is liked
    public String addNotification(SendPostNotification send){

        int postNo = send.getPostId();
        Optional<Post> optional = postRepo.findById(postNo);

        if(!optional.isPresent()) {
            return "this post was not found, you can't liked this post.";
        }

        Notification notification = new Notification();

        // set user and post both into this notification table.
        Post post = optional.get();
        int likes = post.getLikes(); //adding each like for each request

        int setUser = post.getUser().getUserId();
        User user = userRepository.findById(setUser).get();
        notification.setUsers(user); // here both user and post has been set
        notification.setPost(post);

        notificationRepo.save(notification);

        return "notification: user like this post And current like count is " + likes;
    }

}
