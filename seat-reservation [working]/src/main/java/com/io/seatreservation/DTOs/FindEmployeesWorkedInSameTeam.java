package com.io.seatreservation.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindEmployeesWorkedInSameTeam {

    private int employeeId;

    private String team;

    private String name;

}
