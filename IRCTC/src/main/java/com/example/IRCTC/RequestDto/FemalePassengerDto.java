package com.example.IRCTC.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FemalePassengerDto {

    private String gender;
    private int x;
    private int y;
    private String destination;
}
