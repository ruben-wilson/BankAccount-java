package com.bank.assessment.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.assessment.controllers.transaction;
import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.Transaction;
import com.bank.assessment.entities.User;
import com.bank.assessment.repositories.TransactionRepo;

@Service
public class TransactionService {
  
  @Autowired
  TransactionRepo transactionRepo;

  public Transaction createNewTransaction(Transaction transaction, Account account, User user){
    transaction.setUser(user);

    transaction.setAccount(account);
    transaction.setBalance(account.getBalance());

    transaction.setDate(this.getFormattedTime());
    return transaction;
  }

  private String getFormattedTime() {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return currentDate.format(formatter);
  }

  public Transaction addTransaction(Transaction transaction){
    
    return transactionRepo.save(transaction);
  }

  public List<Transaction> findTransactionsByAccountId(int accountId) {
    return transactionRepo.findByAccountId(accountId);
  }
}
