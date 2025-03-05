package com.example.Transactions.Transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity // Marks this class as a JPA entity
public class SystemWallet {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    private Double balance; // Balance of the system wallet

    // No need to manually write getters and setters because of @Data
}
