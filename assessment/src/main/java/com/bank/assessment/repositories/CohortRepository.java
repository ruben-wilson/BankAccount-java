package com.bank.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.assessment.entities.Cohort;

import jakarta.transaction.Transactional;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Integer> {

  @Query("DELETE from Cohort WHERE cohortId = :id")
  @Transactional
  @Modifying
  public int deleteCohortByID(@Param("id") int id);

}
