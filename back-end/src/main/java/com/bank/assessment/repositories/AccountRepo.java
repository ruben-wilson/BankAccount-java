package com.bank.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.assessment.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

  List<Account> findByUser_ID(int id);
  
}
