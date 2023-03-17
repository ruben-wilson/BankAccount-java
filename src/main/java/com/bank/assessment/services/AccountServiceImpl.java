package com.bank.assessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.assessment.entities.Account;
import com.bank.assessment.repositories.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService{

  @Autowired
  AccountRepo accountRepo;

  @Override
  public Account addAccount(Account account) {
    try{

      return accountRepo.save(account);
    }catch(Exception e){

      return null;
    }
   
  }
  

}
