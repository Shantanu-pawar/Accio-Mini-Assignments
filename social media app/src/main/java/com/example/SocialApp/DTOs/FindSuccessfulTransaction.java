package com.example.SocialApp.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindSuccessfulTransaction {

    private String status;
    private int userId;
}
