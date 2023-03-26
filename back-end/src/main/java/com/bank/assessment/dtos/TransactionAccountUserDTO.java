package com.bank.assessment.dtos;

public class TransactionAccountUserDTO {

  private String email;
  private int accountId;
  String transactiontype;
  double amount;
  double balance;
  String date;

  public TransactionAccountUserDTO() {
    super();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getTransactiontype() {
    return transactiontype;
  }

  public void setTransactiontype(String transactiontype) {
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

  @Override
  public String toString() {
    return "TransactionAccountUserDTO [email=" + email + ", accountId=" + accountId + ", transactiontype="
        + transactiontype + ", amount=" + amount + ", balance=" + balance + ", date=" + date + "]";
  }

  
}
