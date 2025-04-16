package com.example.Transactions.Client;

import com.example.Transactions.Client.UserDTO;
import com.example.Transactions.Service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {
    private static final String USER_SERVICE_URL = "http://localhost:8080/users"; // Base URL

    @Autowired
    private RestTemplate restTemplate;

    public UserDTO getUserById(Long userId) throws UserNotFoundException {
        String url = USER_SERVICE_URL + "/" + userId; // Correct URL formation
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }
}
