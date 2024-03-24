package com.io.seatreservation.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buildingNo;

    private String buildingName;

    private int totalSeat;
//
//    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
//    List<Seat> seatList = new ArrayList<>();


}
