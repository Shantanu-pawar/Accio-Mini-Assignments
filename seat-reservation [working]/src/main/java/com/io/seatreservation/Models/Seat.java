package com.io.seatreservation.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "seat")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatNo;

    @Timestamp
    private Date date;

    private String reserved; // for yes or no

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;

    public Seat(Date date, String reserved){
        this.date = date;
        this.reserved = reserved;
    }

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn
//    private Building building;
}