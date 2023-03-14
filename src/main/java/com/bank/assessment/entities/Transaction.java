package com.bank.assessment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Transaction {
  
  @Id
  private int ID;

  private String transactionType;

  private double amount;

  private double balance;

  private String date;

  @ManyToOne
  @JoinColumn(name = "user_ID")
  private User user;

  @ManyToOne
  @JoinColumn(name = "account_ID")
  private Account account;

  

  public Transaction(int iD, String transactionType, double amount, double balance, String date) {
    ID = iD;
    this.transactionType = transactionType;
    this.amount = amount;
    this.balance = balance;
    this.date = date;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  
}
