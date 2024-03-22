package com.example.SocialApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPosts {
    private int userId;

    private String content;

//    @Timestamp
//    private Time time;

}
