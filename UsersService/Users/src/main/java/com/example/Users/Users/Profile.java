package com.example.Users.Users;


import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
}

