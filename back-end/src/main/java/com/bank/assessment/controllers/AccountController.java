package com.bank.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.yaml.snakeyaml.error.YAMLException;

import com.bank.assessment.entities.Account;
import com.bank.assessment.entities.User;
import com.bank.assessment.services.AccountService;

import jakarta.servlet.http.HttpSession;

@RestController
@SessionAttributes("user")
public class AccountController {

  @ModelAttribute("user")
  public User setUser(){
    return new User();
  } 

  @Autowired
  AccountService accountService;
  
  @PostMapping("/account")
  public User addAccount(@ModelAttribute("user") User user){

    System.out.println("Account controller 25: " + user);
    // if(user == null){
    //   return "SignIn";
    // }else{
    //   account.setUser(user);
    //   Account response = accountService.addAccount(account);

    //   System.out.println(account);

    //   return response != null ? "success" : "Error";
    // }
  
    return user;
  } 
  
}
