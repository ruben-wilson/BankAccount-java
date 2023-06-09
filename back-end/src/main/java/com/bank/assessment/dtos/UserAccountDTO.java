package com.bank.assessment.dtos;

public class UserAccountDTO {
  
  private int Id;
  private String email;
  private String password;
  private String firstname;
  private String surname;
  private String type;
  private double balance;

  public UserAccountDTO() {
    super();
  }

  public int getId() {
    return Id;
  }

  public void setId(int Id) {
    this.Id = Id;
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
    return this.surname;
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
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "UserAccountDTO [ID=" + Id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
        + ", surname=" + surname + ", type=" + type + ", balance=" + balance + "]";
  }

  
}
