package com.io.seatreservation.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class SeatEntryDTO {

    private Date date;

    private String reserved;

    // this id is from emp table and have to connect.
    private int employeeId;

    public SeatEntryDTO(Date date, String reserved, int employeeId) {
        this.date = date;
        this.reserved = reserved;
        this.employeeId = employeeId;
    }
}
