package com.bank.assessment.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn; 

@Entity
public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;

  private String accountnum;
  private String type;
  private String firstname;
  private String surname;
  private double balance;
  private String date;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private List<Transaction> transactions;

  public Account(){
    super();
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

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getAccountNum() {
    return accountnum;
  }

  public void setAccountNum(String accountnum) {
    this.accountnum = accountnum;
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



  public User getUser() {
    return user;
  }



  public void setUser(User user) {
    this.user = user;
  }

  

  public List<Transaction> getTransactions() {
    return transactions;
  }



  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Account [ID=" + ID + ", accountnum=" + accountnum + ", type=" + type + ", firstname=" + firstname
        + ", surname=" + surname + ", balance=" + balance + ", date=" + date + ", user=" + user + ", transactions="
        + transactions + "]";
  }


  
  
}
