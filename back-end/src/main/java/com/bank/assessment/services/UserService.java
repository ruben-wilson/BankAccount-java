package com.bank.assessment.services;

import java.util.List;
import com.bank.assessment.entities.User;

public interface UserService {
  public User addUser(User User);

  public List<User> loadAllUsers();

  public User findUserByEmail(String email);

  public  User login(String email, String password);
}
