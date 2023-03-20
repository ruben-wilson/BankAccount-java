package com.bank.assessment.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.assessment.repositories.UserRepo;
import com.bank.assessment.entities.User;

@Service
public class UserServiceImpl implements UserService{
 
  @Autowired
  private UserRepo userRepo;

  public UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public User addUser(User user){
    try{
      return userRepo.save(user);
    }catch(Exception e){
      return null;
    }
  }

  @Override
  public List<User> loadAllUsers() {
    return userRepo.findAll();
  }

  @Override
  public User findUserByEmail(String email){
    return userRepo.findByEmail(email);

  }

  public User login(String email, String password) {

    User user = this.findUserByEmail(email);

    if(user == null)
      return null;
    else
      return user.getPassword().equals(password) ? user : null;
    }

  
  
}
