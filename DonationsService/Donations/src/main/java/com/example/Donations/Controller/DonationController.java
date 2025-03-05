package com.example.Donations.Controller;


import com.example.Donations.Client.UserNotFoundException;
import com.example.Donations.Donations.Donation;
import com.example.Donations.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

//    @PostMapping("/")
//    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) throws UserNotFoundException {
//        Donation newDonation = donationService.createDonation(donation);
//        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
//    @PostMapping("/")
//    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation, @RequestParam Long userId) {
//        Donation newDonation = donationService.createDonation(donation, userId);
//        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);

    @PostMapping("/")
    public ResponseEntity<Donation> createDonation(
            @RequestBody Donation donation,
            @RequestParam Long userId) throws UserNotFoundException {

        Donation newDonation = donationService.createDonation(donation, userId);
        return new ResponseEntity<>(newDonation, HttpStatus.CREATED);
    }
}




