package com.example.Transactions.Client;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
}
