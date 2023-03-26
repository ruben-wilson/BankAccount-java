package com.bank.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.frontend.dtos.TransactionAccountUserDTO;
import com.bank.frontend.model.Transaction;
import com.bank.frontend.model.User;

@Controller
@SessionAttributes("user")
public class TransactionController {

  @Autowired
  RestTemplate restTemplate;

  @PostMapping("/transaction/{accountId}")
  public String makeTransaction(@PathVariable int accountId,@ModelAttribute Transaction transaction, 
                            @ModelAttribute User user){

    TransactionAccountUserDTO dto = new TransactionAccountUserDTO(user.getEmail(), accountId, transaction.getTransactionType(), transaction.getAmount());

    String url = "http://localhost:8080/transaction";
    restTemplate.postForObject(url, dto, String.class);

    return "redirect:/account/" + accountId;
  }


  

}