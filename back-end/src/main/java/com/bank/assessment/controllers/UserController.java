package com.bank.assessment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.bank.assessment.services.UserService;

import jakarta.servlet.http.HttpSession;

import com.bank.assessment.entities.User;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/login")
  public User loginUser(@RequestBody User user) {
    User response = userService.login(user.getEmail(), user.getPassword());

    return response;
  }

  
  @PostMapping("/user")
  public User addUser(@RequestBody User user) {
    
    User response = userService.addUser(user);

    return response;
  }

}
