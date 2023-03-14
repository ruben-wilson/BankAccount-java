package com.bank.assessment.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

  @Id
  private int ID;
  private String firstName;
  private String surname;
  private String email;

  public User(int iD, String firstName, String surname, String email, List<Account> accounts,
      List<Transaction> transactions) {
    ID = iD;
    this.firstName = firstName;
    this.surname = surname;
    this.email = email;
    this.accounts = accounts;
    this.transactions = transactions;
  }


  @OneToMany(mappedBy = "ID")
  private List<Account> accounts;

  public User(int iD, String firstName, String surname, String email, List<Account> accounts) {
    ID = iD;
    this.firstName = firstName;
    this.surname = surname;
    this.email = email;
    this.accounts = accounts;
  }


  @OneToMany(mappedBy = "ID")
  private List<Transaction> transactions;


  public User() {
    super();
  }


  public User(int iD, String firstName, String surname, String email) {
    ID = iD;
    this.firstName = firstName;
    this.surname = surname;
    this.email = email;
  }


  public int getID() {
    return ID;
  }


  public void setID(int iD) {
    ID = iD;
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


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public List<Account> getAccounts() {
    return accounts;
  }


  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }


  public List<Transaction> getTransactions() {
    return transactions;
  }


  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  


  

}
