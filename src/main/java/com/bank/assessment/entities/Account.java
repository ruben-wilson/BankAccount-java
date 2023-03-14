package com.bank.assessment.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn; 

@Entity
public class Account {
  
  @Id
  private int ID;
  private int accountNum;
  private String firstName;
  private String surname;
  private double balance;
  private String date;

  @ManyToOne
  @JoinColumn(name = "ID")
  private User user_ID;

  @OneToMany(mappedBy = "ID")
  private List<Transaction> transactions;

  public Account(int iD, int accountNum, String firstName, String surname, double balance, String date) {
    this.ID = iD;
    this.accountNum = accountNum;
    this.firstName = firstName;
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

  public User getUser_ID() {
    return user_ID;
  }

  public void setUser_ID(User user) {
    this.user_ID = user;
  }

  public int getAccountNum() {
    return accountNum;
  }

  public void setAccountNum(int accountNum) {
    this.accountNum = accountNum;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
  
  
}
