package com.example.IRCTC.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId; // auto Generated

    private int TicketId;

    private int price;

    // one train actually order multiple orders
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Train train;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Passenger passenger;
}
