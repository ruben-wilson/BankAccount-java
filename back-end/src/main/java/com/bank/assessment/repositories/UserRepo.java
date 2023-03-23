package com.bank.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.assessment.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);
  
}


