package com.example.Transactions.Client;

public class TransactionException extends Exception {

    public TransactionException(String message) {
        super(message);  // Pass the message to the parent Exception class
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);  // Pass both message and cause to the parent Exception class
    }
}
