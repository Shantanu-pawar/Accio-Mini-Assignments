package com.example.SocialApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int amount;

    private String status;

    private int amountDeducted;

    @CreationTimestamp
    private Time time;

    // mapped user
    @ManyToOne @JsonIgnore
    @JoinColumn
    private User user;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Refund refund;

}

