package com.bank.assessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bank.assessment.entities.Transaction;
import com.bank.assessment.repositories.TransactionRepo;

@Service
public class TransactionService {
  
  @Autowired
  TransactionRepo transactionRepo;

  public Transaction addTransaction(Transaction transaction){
    
    return transactionRepo.save(transaction);
  }
}
