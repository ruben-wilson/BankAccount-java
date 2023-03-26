package com.bank.frontend.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
import com.bank.frontend.model.Transaction;
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

    restTemplate.postForObject(url, dto, String.class);

    return "redirect:/";
  }

  @GetMapping("/account/{accountId}")
  public ModelAndView accountPage(@PathVariable("accountId") int accountId){

    ModelAndView mv = new ModelAndView();
    mv.setViewName("account");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Account account = new Account();
    account.setId(accountId);

    HttpEntity<Account> accountIdRequest = new HttpEntity<>(account, headers);
    
    String urlTransactions = "http://localhost:8080/findTransactions";
    ResponseEntity<List<Transaction>> transactionResponse = restTemplate.exchange(
        urlTransactions, HttpMethod.POST, accountIdRequest, new ParameterizedTypeReference<List<Transaction>>() {
        });

    List<Transaction> accountTransactions = transactionResponse.getBody();
    Collections.reverse(accountTransactions);

    String urlAccounts = "http://localhost:8080/findAccount";
    Account accountResponse = restTemplate.postForObject(urlAccounts, accountId, Account.class);
  
    mv.addObject("account", accountResponse);
    mv.addObject("transactions", accountTransactions);

    return mv;
  }
  
}
