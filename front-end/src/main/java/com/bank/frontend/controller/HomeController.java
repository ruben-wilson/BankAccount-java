package com.bank.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bank.frontend.model.User;


@Controller
@SessionAttributes("user")
public class HomeController {


  @ModelAttribute("user")
  public User setUser() {
    return new User();
  }
  
  @GetMapping("/")
  public String getHome(@ModelAttribute("user") User user){

    System.out.println("home 14: " + user);
    if(user.getEmail() == null){
      return "redirect:/login";
    }else{
      return "home";
    }

  }

}
