package com.example.Donations.Client;

import com.example.Donations.Users.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private UserRole role; // Maps role to donor, beneficiary, or admin
}
