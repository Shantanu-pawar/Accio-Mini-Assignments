package com.example.SocialApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String content;

    @CreationTimestamp
    private Time time;

    private int likes;

    // save user here
    @ManyToOne
    @JoinColumn @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();

}

