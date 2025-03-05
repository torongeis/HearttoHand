package com.example.Transactions.Service;

import com.example.Transactions.Client.DonationsServiceClient;
import com.example.Transactions.Repository.TransactionRepository;
import com.example.Transactions.Transaction.Transaction;
import com.example.Transactions.Client.TransactionException;
import com.example.Transactions.Client.DonationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private DonationsServiceClient donationsServiceClient;  // Client to communicate with Donations Service

    @Autowired
    private TransactionRepository transactionRepository;  // Repository to save transactions

    // Fetch all donations (transactions)
    public List<Transaction> getAllDonations() {
        // Return all transactions (donations) from the repository
        return transactionRepository.findAll();
    }
    // Assign donation to a beneficiary once approved by admin
    public Transaction assignToBeneficiary(Long transactionId, Long beneficiaryId, Long approvedBy) throws TransactionException, DonationNotFoundException {
        try {
            // Fetch donation details using the transactionId
            Optional<Transaction> transactionOptional = transactionRepository.findById(transactionId);

            if (!transactionOptional.isPresent()) {
                // If transaction not found, throw exception
                throw new DonationNotFoundException("Transaction not found for ID: " + transactionId);
            }

            // Get the transaction from the Optional
            Transaction transaction = transactionOptional.get();

            // Check if the transaction is already assigned
            if (transaction.getBeneficiaryId() != null) {
                throw new TransactionException("This transaction is already assigned to a beneficiary.");
            }

            // Set the beneficiary ID, status, and approved by fields
            transaction.setBeneficiaryId(beneficiaryId);
            transaction.setStatus("ASSIGNED");
            transaction.setApprovedBy(approvedBy);
            transaction.setUpdatedAt(System.currentTimeMillis());  // Update timestamp

            // Save the updated transaction
            transactionRepository.save(transaction);

            return transaction;

        } catch (DonationNotFoundException e) {
            throw new TransactionException("Donation not found: " + e.getMessage());
        } catch (Exception e) {
            throw new TransactionException("Error processing beneficiary assignment: " + e.getMessage());
        }
    }
}
