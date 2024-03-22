package com.example.SocialApp.services;

import com.example.SocialApp.DTOs.AddPosts;
import com.example.SocialApp.DTOs.MaxLikedUserResponseDto;
import com.example.SocialApp.models.Post;
import com.example.SocialApp.models.User;
import com.example.SocialApp.repository.PostRepo;
import com.example.SocialApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepository userRepository;

    public String addPost(AddPosts addPosts) throws Exception{

        int userId = addPosts.getUserId();
        Post post = new Post();
        post.setContent(addPosts.getContent());

        Optional<User> op = userRepository.findById(userId);
        if(!op.isPresent()) {
         throw new Exception( "register your user first before adding post");
        }

        User user = op.get();
        post.setUser(user);
//        post.setLikes(post.getLikes());
        postRepo.save(post);

        return "Post added successfully with user id: " + userId;
    }

    public Post likeGivenPost(int postId){

        Optional<Post> op = postRepo.findById(postId);
        Post post = op.get();
        post.setLikes(post.getLikes() + 1);

        postRepo.save(post);

        return post;
    }

    public MaxLikedUserResponseDto findMostLikedUser(){

        List<User> allUsers = userRepository.findAll();
        User maxLikedUser = null;
        int maxLikes = 0;

        for(User user : allUsers){
            List<Post> postlist = user.getPostList();

            int count = 0;
            for(Post post : postlist){
                count += post.getLikes();
            }

            if(count > maxLikes){
                maxLikes = count;
                maxLikedUser = user;
            }
        }
        // set the responseDto
        MaxLikedUserResponseDto response = new MaxLikedUserResponseDto();
        response.setUserId(maxLikedUser.getUserId());
        response.setPostCount(maxLikedUser.getPostList().size());
        response.setAllLikes(maxLikes);
        response.setUserName(maxLikedUser.getName());
        return response;
    }
}
