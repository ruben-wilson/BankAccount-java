package com.bank.assessment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Transaction {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;

  private String transactiontype;

  private double amount;

  private double balance;

  private String date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_ID")
  private User user;

  @ManyToOne
  @JoinColumn(name = "account_ID")
  private Account account;

  

  public Transaction(int iD, String transactiontype, double amount, double balance, String date) {
    ID = iD;
    this.transactiontype = transactiontype;
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
    return transactiontype;
  }

  public void setTransactionType(String transactiontype) {
    this.transactiontype = transactiontype;
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
