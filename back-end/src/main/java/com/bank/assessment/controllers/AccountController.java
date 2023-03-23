package com.bank.assessment.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bank.assessment.dtos.UserAccountDTO;
import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.User;
import com.bank.assessment.services.AccountServiceImpl;
import com.bank.assessment.services.UserServiceImpl;

@RestController
public class AccountController {

  @Autowired
  AccountServiceImpl accountService;

  @Autowired
  UserServiceImpl userService;
  
  @PostMapping("/account")
  public String addAccount(@RequestBody UserAccountDTO dto){

    User user = userService.findUserByEmail(dto.getEmail());

    System.out.println("Account controller 25: " + dto);

    Account accountDetails = new Account(null, dto.getType(), dto.getFirstname(), dto.getSurname(), dto.getBalance(), null);

    Account account = accountService.createAccount(accountDetails);

    account.setUser(user);

    System.out.println("Account controller 40: " + account);

    Account response  = accountService.addAccount(account);

    return response != null ? "received" : "Error";  
  } 

  @PostMapping("/findUserAccounts")
  public List<Account> findUserAccounts(@RequestBody User user){
  
   return accountService.findUsersAccounts(user.getID());
  }

  @GetMapping("/allAccounts")
  public List<Account> allAccounts() {

    return accountService.findAll();
  }
  
}
