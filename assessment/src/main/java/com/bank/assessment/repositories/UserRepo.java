package com.bank.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

import com.bank.assessment.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);
  
}


