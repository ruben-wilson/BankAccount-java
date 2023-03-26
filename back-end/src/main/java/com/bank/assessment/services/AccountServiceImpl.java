package com.bank.assessment.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.assessment.entities.Account;
import com.bank.assessment.repositories.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService{

  @Autowired
  AccountRepo accountRepo;

  public List<Account> findUsersAccounts(int user_id) {
    return accountRepo.findByUser_ID(user_id);
  }

  public Account createAccount(Account account) {
    account.setAccountNum(this.generateAccountNum(account));
    account.setDate(this.getFormattedTime());
    return account;
  }

  public String getFormattedTime() {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return currentDate.format(formatter);
   
  }

  public String generateAccountNum(Account account) {

    return account.getType().equals("savingsAccount") ? "S3V" + Integer.toString(this.randomNumberGenerator()) : "C6N" + Integer.toString(this.randomNumberGenerator());
  }

  public int randomNumberGenerator(){
    int m = (int) Math.pow(10, 10 - 1);
    return m + new Random().nextInt(9 * m);

  //  return (int) ThreadLocalRandom.current().nextLong((long) Math.pow(10, 10), (long) Math.pow(10, 11));
  }

  @Override
  public Account addAccount(Account account) {
    try {

      return accountRepo.save(account);

    } catch (Exception e) {

      return null;
    }
  }

  public List<Account> findAll() {
    return accountRepo.findAll();
  }

  public Account findAccount(int id) {
    
    return accountRepo.findById(id).get();
  }

  public void updateAccountBalance(int id, double balance) {
    accountRepo.updateBalanceById(balance, id);
  }

  

}
