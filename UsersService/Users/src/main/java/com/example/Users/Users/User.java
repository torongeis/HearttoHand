package com.example.Users.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private String role; // Donor, Beneficiary, Admin
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Version // Enables optimistic locking
    private int version;
}
