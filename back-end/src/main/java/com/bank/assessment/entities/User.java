package com.bank.assessment.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ID;
  private String firstname;
  private String surname;
  private String email;
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonBackReference
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private List<Account> accounts;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonBackReference
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private List<Transaction> transactions;

  public User(){
    super(); 
  }

  public User(String email, String password) {
    super();
    this.email = email;
    this.password = password;
  }

  public User(String firstname, String surname, String email, String password) {
    super();
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }

  public User(int id, String firstname, String surname, String email, String password) {
    super();
    this.ID = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }

  public User(int id, String firstname, String surname, String email, String password, List<Account> accounts,
      List<Transaction> transactions) {
    this.ID = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.accounts = accounts;
    this.transactions = transactions;
  }

  public User(int id, String firstname, String surname, String email, String password, List<Transaction> transactions) {
    ID = id;
    this.firstname = firstname;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.transactions = transactions;
  }

  public int getID() {
    return ID;
  }


  public void setID(int id) {
    ID = id;
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

  @Override
  public String toString() {
    return "User [ID=" + ID + ", firstname=" + firstname + ", surname=" + surname + ", email=" + email + ", password="
        + password + "]";
  }

  


}
