package com.bank.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.assessment.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
  
}
