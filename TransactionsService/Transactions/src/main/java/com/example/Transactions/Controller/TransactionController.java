package com.example.Transactions.Controller;

import com.example.Transactions.Service.TransactionService;
import com.example.Transactions.Transaction.Transaction;
import com.example.Transactions.Client.TransactionException;
import com.example.Transactions.Client.DonationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Endpoint to fetch all donations (transactions)
    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllDonations() {
        List<Transaction> transactions = transactionService.getAllDonations();
        return ResponseEntity.ok(transactions);
    }

    // Endpoint to assign a donation to a beneficiary (once approved by admin)
    @PostMapping("/assign/{transactionId}")
    public ResponseEntity<Transaction> assignToBeneficiary(
            @PathVariable Long transactionId,
            @RequestParam Long beneficiaryId,
            @RequestParam Long approvedBy) throws TransactionException, DonationNotFoundException {

        Transaction updatedTransaction = transactionService.assignToBeneficiary(transactionId, beneficiaryId, approvedBy);
        return ResponseEntity.ok(updatedTransaction);

        }

    }

