package com.example.Transactions.Client;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DonationsDTO {
    private Long donationId;
    private Long donorId;
    private Double amount;
    private LocalDateTime donationDate;
    private String status; // Pending, Completed, Failed
}
