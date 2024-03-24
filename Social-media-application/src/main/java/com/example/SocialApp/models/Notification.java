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
public class Notification{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;

    @CreationTimestamp
    private Time time;

    // save user here
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User users;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Post post;

}

