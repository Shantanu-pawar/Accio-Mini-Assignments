package com.example.SocialApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refundId;

    private int amount;


    // save user here
    @OneToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    @OneToOne
    @JsonIgnore
    @JoinColumn
    private Transaction transaction;

}

