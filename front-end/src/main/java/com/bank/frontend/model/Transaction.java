package com.bank.frontend.model;

public class Transaction {

     int ID;

     String transactiontype;

     double amount;

     double balance;

     String date;

    public Transaction() {
      super();
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

    @Override
    public String toString() {
      return "Transaction [ID=" + ID + ", transactiontype=" + transactiontype + ", amount=" + amount + ", balance="
          + balance + ", date=" + date + "]";
    }

    

}
