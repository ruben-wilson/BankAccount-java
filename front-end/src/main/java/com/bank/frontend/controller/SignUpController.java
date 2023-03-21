package com.bank.frontend.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.bank.frontend.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class SignUpController {

  @Autowired
  RestTemplate restTemplate;
  
  @GetMapping("/signUp")
  public String getSignUp(){

    return "signUp";
  }

  @PostMapping("/signUp")
  public String getSignUp(@ModelAttribute User loginFormData, Model model) {
    String url = "http://localhost:8080/user";

    User response = restTemplate.postForObject(url, loginFormData, User.class);

    model.addAttribute("user", response);
    return "redirect:/";
  }

}
