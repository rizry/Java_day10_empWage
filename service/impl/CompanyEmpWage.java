package com.empwage.service.impl;

public class CompanyEmpWage {
  public final String name;
  public final short empWagePerHr;
  public final short daysToWork;
  public final int hrsToWork;
  public int monthlyEmpWage;

  public CompanyEmpWage(String name, short empWagePerHr, short daysToWork, int hrsToWork) {
    this.name = name;
    this.empWagePerHr = empWagePerHr;
    this.daysToWork = daysToWork;
    this.hrsToWork = hrsToWork;
  }

  public void setMonthlyEmpWage(int wage) {
    monthlyEmpWage = wage;
  }

  @Override
  public String toString() {
    return "\nEmployee at " + name + " makes " + monthlyEmpWage + "$ a month.";
  }

}