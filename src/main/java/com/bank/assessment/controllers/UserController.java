package com.bank.assessment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;


import com.bank.assessment.services.UserService;

import jakarta.servlet.http.HttpSession;

import com.bank.assessment.entities.User;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/login")
  public User loginUser(@RequestBody User user, HttpSession session) {
    User response = userService.login(user.getEmail(), user.getPassword());
    session.setAttribute("user", response);

    return response != null ? response : null;
  }

  @PostMapping("/user")
  public String addUser(@RequestBody User user) {
    
    User result = userService.addUser(user);

    return result != null ? "success" : "Error";
  }

}
