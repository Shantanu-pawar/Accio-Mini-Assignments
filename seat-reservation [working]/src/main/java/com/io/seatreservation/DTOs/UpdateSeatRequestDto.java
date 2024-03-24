package com.io.seatreservation.DTOs;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateSeatRequestDto {

    private int seat_no;
    private Date date;
    private String reserved;
    private int employee_id;

    private String name;
    private String team;
}
