package com.example.IRCTC.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPassengerDto {
    private int age;
    private Date date;
    private String gender;
    private int ticketId;

    // foreign key attribute
    private int trainId;

    public AddPassengerDto(int age, Date date, String gender, int ticketId) {
        this.age = age;
        this.date = date;
        this.gender = gender;
        this.ticketId = ticketId;
    }
}
