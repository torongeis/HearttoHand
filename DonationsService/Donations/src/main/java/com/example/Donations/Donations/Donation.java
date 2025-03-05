package com.example.Donations.Donations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;// Foreign key reference to Donations Table

    private Long donorId;// Foreign key reference to Users

    private Long beneficiaryId;// Foreign key reference to Users

    private Double amount;

    private String status; // Pending, Completed, Failed

    @CreationTimestamp // Auto-set when first saved
    private LocalDateTime createdAt;

    @UpdateTimestamp // Auto-update on changes
    private LocalDateTime updatedAt;

    private LocalDateTime donationDate;
}
