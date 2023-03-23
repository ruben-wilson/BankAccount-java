package com.bank.frontend.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bank.frontend.model.Account;
import com.bank.frontend.model.User;



@Controller
@SessionAttributes("user")
public class HomeController {

  @ModelAttribute("user")
  public User setUser() {
    return new User();
  }

  @Autowired
  RestTemplate restTemplate;
  
  @GetMapping("/")
  public ModelAndView getHome(@ModelAttribute("user") User user){
    ModelAndView mv = new ModelAndView();
    System.out.println("home 14: " + user);
    if(user.getFirstname() == null){
      mv.setViewName("login");
      return mv;
    }else{

      String url = "http://localhost:8080/findUserAccounts";
      mv.setViewName("home");

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<User> userRequest = new HttpEntity<>(user, headers);

      ResponseEntity<List<Account>> response = restTemplate.exchange(
          url, HttpMethod.POST, userRequest, new ParameterizedTypeReference<List<Account>>() {
          });

      List<Account> userAccounts = response.getBody();

      double totalSavings = userAccounts.stream()
                  .filter(a -> a.getType().equals("savingsAccount") )
                  .map(a -> a.getBalance())
                  .mapToInt(Double::intValue).sum();

      double totalMoney = userAccounts.stream()
          .map(a -> a.getBalance())
          .mapToInt(Double::intValue).sum();

      
      mv.addObject("totalSavings", totalSavings);
      mv.addObject("totalMoney", totalMoney);
      mv.addObject("userAccounts", userAccounts);
        

      return mv;
    }
  }

  @GetMapping("/login")
  public String getLoginPage() {

    return "login";
  }

  @PostMapping("/login")
  public String postLoginPage(@ModelAttribute User user, Model model) {
    String url = "http://localhost:8080/login";

    User response = restTemplate.postForObject(url, user, User.class);
    
    model.addAttribute("user", response);

    return response == null ? "redirect:/login" : "redirect:/";
  }

}
