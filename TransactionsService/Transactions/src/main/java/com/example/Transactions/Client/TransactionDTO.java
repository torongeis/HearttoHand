package com.example.Transactions.Client;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Amount is required")
    private Double amount;

    private Long donationId;  // Add donationId field here

    private LocalDateTime transactionDate = LocalDateTime.now();
    private String transactionType; // Deposit or Disbursement
}
