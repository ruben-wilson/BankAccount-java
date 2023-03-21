package com.bank.frontend.model;

public class Account {

  public String firstname;
  public String accountnum;
  public String date;
  public String surname;
  public String type;
  public double balance;

  public Account(){
    super();
  }

  public Account(String firstname, String surname, String inlineRadioOptions, double balance) {
    this.firstname = firstname;
    this.surname = surname;
    this.type = inlineRadioOptions;
    this.balance = balance;
  }

  public Account(String accountnum, String type, String firstname, String surname, double balance, String date) {
    super();
    this.accountnum = accountnum;
    this.type = type;
    this.firstname = firstname;
    this.surname = surname;
    this.balance = balance;
    this.date = date;
  }
  

  public String getFirstName() {
    return firstname;
  }

  public void setFirstName(String firstname) {
    this.firstname = firstname;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Account [firstname=" + firstname + ", surname=" + surname + ", type=" + type + ", balance=" + balance + "]";
  }


  public double getBalance() {
    return this.balance;
  }


  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountnum() {
    return this.accountnum;
  }

  public void setAccountnum(String accountnum) {
    this.accountnum = accountnum;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  

  
}
