package com.bank.frontend.model;

import java.util.List;

public class User {
  private int ID;
  private String firstname;
  private String surname;
  private String email;
  private String password;

  private List<Account> accounts;
  private List<Transaction> transactions;

  public User(){
    super();
  }

  public User(String email, String password) {
    super();
    this.email = email;
    this.password = password;
  }

  public User(int ID, String firstname, String surname, String email, String password) {
    super();
    this.ID = ID;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }

  public User(int iD, String firstname, String surname, String email, String password, List<Account> accounts,
      List<Transaction> transactions) {
    this.ID = iD;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.accounts = accounts;
    this.transactions = transactions;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
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

  @Override
  public String toString() {
    return "User [ID=" + ID + ", firstname=" + firstname + ", surname=" + surname + ", email=" + email + ", password="
        + password + ", accounts=" + accounts + ", transactions=" + transactions + "]";
  }

  

}
