package com.example.SocialApp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaxLikedUserResponseDto {

    private int userId;
    private int postCount;
    private int allLikes;
    private String userName;
}
