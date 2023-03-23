package com.bank.frontend.model;

public class Account {

  private int id;
  private String firstname;
  private String accountnum;
  private String date;
  private String surname;
  private String type;
  private double balance;
  private String inlineRadioOptions;
  

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
  
  
  
  public String createType(){
    return this.type == null ? this.getInlineRadioOptions() : this.getType();
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
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



  public double getBalance() {
    return this.balance;
  }


  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountNum() {
    return this.accountnum;
  }

  public void setAccountNum(String accountnum) {
    this.accountnum = accountnum;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getInlineRadioOptions() {
    return inlineRadioOptions;
  }

  public void setInlineRadioOptions(String inlineRadioOptions) {
    this.inlineRadioOptions = inlineRadioOptions;
  }

  @Override
  public String toString() {
    return "Account [firstname=" + firstname + ", accountnum=" + accountnum + ", date=" + date + ", surname=" + surname
        + ", type=" + type + ", balance=" + balance + ", inlineRadioOptions=" + inlineRadioOptions + "]";
  }

  public int getId() {
    return id;
  }

  public String getAccountnum() {
    return accountnum;
  }


  
  

  
}
