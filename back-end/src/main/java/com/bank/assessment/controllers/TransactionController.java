package com.bank.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.assessment.dtos.TransactionAccountUserDTO;
import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.Transaction;
import com.bank.assessment.entities.User;
import com.bank.assessment.services.AccountServiceImpl;
import com.bank.assessment.services.TransactionService;
import com.bank.assessment.services.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @Autowired
  AccountServiceImpl accountService;

  @Autowired
  UserServiceImpl userService;


  
  @PostMapping("/transaction")
  public String addTransaction(@RequestBody TransactionAccountUserDTO dto){

    User user = userService.findUserByEmail(dto.getEmail());
    Account account = accountService.findAccount(dto.getAccountId());

    Transaction transaction = new Transaction(0, dto.getTransactiontype(), dto.getAmount(), dto.getBalance(), dto.getDate());

    transaction = transactionService.createNewTransaction(transaction, account, user);

    System.out.println(transaction.getTransactionType());
    double balance = transaction.getTransactionType().equals("withdraw") ? account.getBalance() - transaction.getAmount() : account.getBalance() + transaction.getAmount();

    System.out.println(balance);    
    accountService.updateAccountBalance(account.getID(), balance);

    System.out.println(transaction);
    transactionService.addTransaction(transaction);
    return "received";
  }

  @PostMapping("/findTransactions")
  public List<Transaction> getMethodName(@RequestBody Account account) {
    
    return transactionService.findTransactionsByAccountId(account.getID());
  }
  
}
