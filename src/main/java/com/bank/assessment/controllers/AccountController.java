package com.bank.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.User;
import com.bank.assessment.services.AccountService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AccountController {

  @Autowired
  AccountService accountService;
  
  @PostMapping("/account")
  public String addAccount(@RequestBody Account account, HttpSession session){
    User user = (User) session.getAttribute("user");
    
    if(user == null){
      return "SignIn";
    }else{
      account.setUser(user);
      Account response = accountService.addAccount(account);

      System.out.println(account);

      return response != null ? "success" : "Error";
    }
  
  } 
  
}
