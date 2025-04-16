package com.example.Transactions.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DonationsServiceClient {
    private static final String DONATIONS_SERVICE_URL = "http://localhost:8081/donations";

    @Autowired
    private RestTemplate restTemplate;

    public DonationsDTO getDonationById(Long donationId) throws DonationNotFoundException {
        String url = DONATIONS_SERVICE_URL + "/" + donationId;
        ResponseEntity<DonationsDTO> response = restTemplate.getForEntity(url, DonationsDTO.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new DonationNotFoundException("Donation not found with ID: " + donationId);
        }
    }
}
