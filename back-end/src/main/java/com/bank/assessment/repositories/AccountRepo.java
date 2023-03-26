package com.bank.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bank.assessment.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

  List<Account> findByUser_ID(int id);

  @Transactional
  @Modifying
  @Query("UPDATE Account a SET a.balance = :balance WHERE a.id = :id")
  void updateBalanceById(Double balance, int id);
  
}
