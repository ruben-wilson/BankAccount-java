package com.bank.assessment.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // This class represents a table
// @Table(name="cohort_details")
public class Cohort {

  @Id // This indicates PK
  // @GeneratedValue(strategy = GenerationType.AUTO)
  private int cohortId;

  private String cohortTitle;

  private String startDate;

  @OneToMany(mappedBy = "cohortId")
  private List<Pioneer> pioneers;

  public Cohort() {
    super();
  }

  public Cohort(int cohortId, String cohortTitle, String startDate) {
    super();
    this.cohortId = cohortId;
    this.cohortTitle = cohortTitle;
    this.startDate = startDate;
  }

  public Cohort(int cohortId, String cohortTitle, String startDate, List<Pioneer> pioneers) {
    super();
    this.cohortId = cohortId;
    this.cohortTitle = cohortTitle;
    this.startDate = startDate;
    this.pioneers = pioneers;
  }

  public int getCohortId() {
    return cohortId;
  }

  public void setCohortId(int cohortId) {
    this.cohortId = cohortId;
  }

  public String getCohortTitle() {
    return cohortTitle;
  }

  public void setCohortTitle(String cohortTitle) {
    this.cohortTitle = cohortTitle;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public List<Pioneer> getPioneers() {
    return pioneers;
  }

  public void setPioneers(List<Pioneer> pioneers) {
    this.pioneers = pioneers;
  }

  @Override
  public String toString() {
    return "Cohort [cohortId=" + cohortId + ", cohortTitle=" + cohortTitle + ", startDate=" + startDate
        + ", pioneers=" + pioneers + "]";
  }

}
