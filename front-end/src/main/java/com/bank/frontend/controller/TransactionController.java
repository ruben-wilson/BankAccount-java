package com.bank.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {

  @GetMapping("/deposit/{accountId}")
  public ModelAndView makeDeposit(@PathVariable int accountId){
    ModelAndView mv = new ModelAndView();

    System.out.println(accountId);

    return mv;
  }
  

}