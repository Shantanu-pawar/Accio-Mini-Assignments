package com.io.seatreservation.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TopRated5RequestDto {


    private int employeeId;
    private String name;

    private int seatCount;
}
