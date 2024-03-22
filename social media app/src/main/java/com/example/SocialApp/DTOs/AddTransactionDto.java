package com.example.SocialApp.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTransactionDto {

    private int amount;

    private String status;

    private int amountDeducted;

    private int userId;
}
