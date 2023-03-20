package com.bank.assessment.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pioneer {

  @Id
  private int pioneerId;

  private String pioneerName;

  private String pioneerEmail;

  @ManyToOne
  @JoinColumn(name = "cohort_id")
  private Cohort cohortId;

  public Pioneer() {
    super();
  }

  public Pioneer(int pioneerId, String pioneerName, String pioneerEmail, Cohort cohortId) {
    super();
    this.pioneerId = pioneerId;
    this.pioneerName = pioneerName;
    this.pioneerEmail = pioneerEmail;
    this.cohortId = cohortId;
  }

  public int getPioneerId() {
    return pioneerId;
  }

  public void setPioneerId(int pioneerId) {
    this.pioneerId = pioneerId;
  }

  public String getPioneerName() {
    return pioneerName;
  }

  public void setPioneerName(String pioneerName) {
    this.pioneerName = pioneerName;
  }

  public String getPioneerEmail() {
    return pioneerEmail;
  }

  public void setPioneerEmail(String pioneerEmail) {
    this.pioneerEmail = pioneerEmail;
  }

  public Cohort getCohortId() {
    return cohortId;
  }

  public void setCohortId(Cohort cohortId) {
    this.cohortId = cohortId;
  }

  @Override
  public String toString() {
    return "Pioneer [pioneerId=" + pioneerId + ", pioneerName=" + pioneerName + ", pioneerEmail=" + pioneerEmail
        + ", cohortId=" + cohortId + "]";
  }

}