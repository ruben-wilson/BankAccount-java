package com.bank.frontend.dtos;

import com.bank.frontend.model.Account;
import com.bank.frontend.model.User;

public class UserAccountDTO {

  private int ID;
  private String email; 
  private String password;
  private String firstname;
  private String surname;
  private String type;
  private double balance;

  public UserAccountDTO(User user, Account account) {
   this.ID = user.getID();
   this.email = user.getEmail();
   this.password = user.getPassword();
   this.firstname = user.getFirstname();
   this.surname = user.getSurname();

   this.type = account.getType();
   this.balance = account.getBalance();
  }

  public UserAccountDTO() {
    super();
  }

  
  @Override
  public String toString() {
    return "UserAccountDTO [ID=" + ID + ", email=" + email + ", password=" + password + ", firstname=" + firstname
        + ", surname=" + surname + ", type=" + type + ", balance=" + balance + "]";
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

}
