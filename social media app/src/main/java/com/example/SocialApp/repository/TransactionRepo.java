package com.example.SocialApp.repository;

import com.example.SocialApp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    public List<Transaction> findByStatus(String status);

}
