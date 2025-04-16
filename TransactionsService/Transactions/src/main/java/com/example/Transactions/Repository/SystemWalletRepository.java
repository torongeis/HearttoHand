package com.example.Transactions.Repository;



import com.example.Transactions.Transaction.SystemWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface SystemWalletRepository extends JpaRepository<SystemWallet, Long> {
        // Custom query methods (if needed)
    }

