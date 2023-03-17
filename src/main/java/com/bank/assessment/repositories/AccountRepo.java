package com.bank.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.assessment.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
  
}
