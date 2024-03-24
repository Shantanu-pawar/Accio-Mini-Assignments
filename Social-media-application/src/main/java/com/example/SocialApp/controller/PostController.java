package com.example.SocialApp.controller;

import com.example.SocialApp.DTOs.AddPosts;
import com.example.SocialApp.DTOs.MaxLikedUserResponseDto;
import com.example.SocialApp.models.Post;
import com.example.SocialApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/addPost")
    public String addPost(@RequestBody AddPosts addPosts){
        try{
            return postService.addPost(addPosts);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/likeAPost")
    public ResponseEntity<?> likePost(@RequestParam int postId){

        try{
            Post post = postService.likeGivenPost(postId);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findMostLikedUser")
    public ResponseEntity<?> findMaxLikedUser(){
        try{
            MaxLikedUserResponseDto user = postService.findMostLikedUser();
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
