package com.bank.frontend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.frontend.dtos.UserAccountDTO;
import com.bank.frontend.model.Account;
import com.bank.frontend.model.User;

@Controller
@SessionAttributes("user")
public class AccountController {
  
  @Autowired
  RestTemplate restTemplate;
  

  @GetMapping("/account")
  public String getAccount() {

    return "createAccount";
  }


  @PostMapping("/account")
  public String postAccount(@ModelAttribute Account account, @ModelAttribute User user){
    
    account.setType(account.createType());
    
    UserAccountDTO dto = new UserAccountDTO(user, account);

    String url = "http://localhost:8080/account";
    
    System.out.println("account 30: " + dto);

    String response = restTemplate.postForObject(url, dto, String.class);

    System.out.println("account 32: " + response);
    return "redirect:/";
  }

  @GetMapping("/account/{accountId}")
  public ModelAndView accountPage(@PathVariable("accountId") int accountId){

    ModelAndView mv = new ModelAndView();
    mv.setViewName("account");
  
    String url = "http://localhost:8080/findAccount";
    Account response = restTemplate.postForObject(url, accountId, Account.class);
  
    mv.addObject("account", response);

    return mv;
  }
}
