package com.example.IRCTC.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int passengerId; // auto Generated

    private int ticketId;

    @Timestamp
    private Date date;

    private int age;

    private String gender;

    public Passenger(int ticketId, Date date, int age, String gender) {
        this.ticketId = ticketId;
        this.date = date;
        this.age = age;
        this.gender = gender;
    }

    // one train many Passengers
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Train train;

    // one passenger many foodOrders
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<FoodOrder> passengerList = new ArrayList<>();
}

