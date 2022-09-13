package com.empwage.service.impl;

import java.util.ArrayList;

public class CompanyEmpWage {
  public final String name;
  public final short empWagePerHr;
  public final short daysToWork;
  public final int hrsToWork;
  public int monthlyEmpWage;
  public ArrayList<Short> dailyWageArr;

  public CompanyEmpWage(String name, short empWagePerHr, short daysToWork, int hrsToWork) {
    this.name = name;
    this.empWagePerHr = empWagePerHr;
    this.daysToWork = daysToWork;
    this.hrsToWork = hrsToWork;

    dailyWageArr = new ArrayList<>();
  }

  public void setMonthlyEmpWage(int wage) {
    monthlyEmpWage = wage;
  }

  public void addDailyEmpWage(short dailyEmpWage) {
    this.dailyWageArr.add(dailyEmpWage);
  }

  @Override
  public String toString() {
    System.out.println("\nDaily wage array " + dailyWageArr);
    return "Employee at " + name + " makes " + monthlyEmpWage + "$ a month.";
  }

}