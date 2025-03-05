package com.example.Donations.Client;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super("User not found!!");
    }
}
