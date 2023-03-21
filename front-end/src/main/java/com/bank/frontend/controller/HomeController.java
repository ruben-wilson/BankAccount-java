package com.bank.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

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
  public String getHome(@ModelAttribute("user") User user){

    System.out.println("home 14: " + user);
    if(user.getFirstname() == null){
      return "redirect:/login";
    }else{
      return "home";
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

    System.out.println("login 35: " + response);
    
    model.addAttribute("user", response);

    return response == null ? "redirect:/login" : "redirect:/";
  }

}
