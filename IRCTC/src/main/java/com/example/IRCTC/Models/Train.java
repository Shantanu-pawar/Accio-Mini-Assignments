package com.example.IRCTC.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TrainId; // auto Generated

    private int trainNo;

    private String startPoint;

    private String Destination;

    // one train actually booked by many passengers
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Passenger> passengerList = new ArrayList<>();

    // one train actually order multiple orders
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrderList = new ArrayList<>();
}
