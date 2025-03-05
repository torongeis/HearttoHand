package com.example.Donations.Repository;


import com.example.Donations.Donations.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
