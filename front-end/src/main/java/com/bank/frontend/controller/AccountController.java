package com.bank.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.bank.frontend.model.User;

@Controller
public class AccountController {
  
  @Autowired
  RestTemplate restTemplate;
  


  @PostMapping("/account")
  public String postAccount(){
    String url = "http://localhost:8080/account";

    String string = "gf";

    String response = restTemplate.postForObject(url, string, String.class);

    return "";
  }
}
