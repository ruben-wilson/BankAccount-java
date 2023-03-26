package com.bank.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.assessment.controllers.transaction;
import com.bank.assessment.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

  @Query("SELECT t FROM Transaction t WHERE t.account.id = :accountId")
  List<Transaction> findByAccountId(int accountId);
   
}
