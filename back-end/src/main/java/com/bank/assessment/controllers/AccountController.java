package com.bank.assessment.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.yaml.snakeyaml.error.YAMLException;

import com.bank.assessment.dtos.UserAccountDTO;
import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.User;
import com.bank.assessment.services.AccountService;
import com.bank.assessment.services.AccountServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class AccountController {

  @Autowired
  AccountServiceImpl accountService;
  
  @PostMapping("/account")
  public String addAccount(@RequestBody UserAccountDTO dto){

    User user = new User(dto.getID(), dto.getFirstname(), dto.getSurname(), dto.getEmail(), dto.getPassword());

    Account accountDetails = new Account(null, dto.getType(), dto.getFirstname(), dto.getSurname(), dto.getBalance(), null);

    System.out.println("Account controller 25: " + dto);
    
    Account account = accountService.createAccount(accountDetails);

    account.setUser(user);

    System.out.println("Account controller 40: " + account);

    accountService.addAccount(account);

    return "recieved";

   
  } 
  
}
