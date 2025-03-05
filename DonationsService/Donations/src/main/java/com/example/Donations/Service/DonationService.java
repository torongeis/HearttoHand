package com.example.Donations.Service;

import com.example.Donations.Client.UserDTO; // Import UserDTO instead of User
import com.example.Donations.Client.UserServiceClient;
import com.example.Donations.Donations.Donation;
import com.example.Donations.Repository.DonationRepository;
import com.example.Donations.Users.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DonationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserServiceClient userServiceClient;



public Donation createDonation(Donation donation, Long userId) {
    // Fetch user details from Users Service
    UserDTO user = restTemplate.getForObject("http://localhost:8080/users/" + userId, UserDTO.class);

    if (user == null) {
        throw new RuntimeException("User not found");
    }

    // Assign donorId or beneficiaryId based on role
    if (user.getRole() == UserRole.DONOR) {
        donation.setDonorId(user.getUserId());
    } else if (user.getRole() == UserRole.BENEFICIARY) {
        donation.setBeneficiaryId(user.getUserId());
    } else {
        throw new RuntimeException("Only DONORs and BENEFICIARYs can make donations");
    }

    return donationRepository.save(donation);
}
}


