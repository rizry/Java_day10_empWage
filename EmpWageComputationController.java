package com.empwage;

import com.empwage.service.EmpWageService;
import com.empwage.service.impl.EmpWageServiceImpl;

public class EmpWageComputationController {

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--");

    EmpWageService Reliance = new EmpWageServiceImpl("Reliance", (short) 20, (short) 100, (byte) 20);
    EmpWageService Amazon = new EmpWageServiceImpl("Amazon", (short) 30, (short) 120, (byte) 25);
    EmpWageService Google = new EmpWageServiceImpl("Google", (short) 50, (short) 130, (byte) 25);

    Reliance.getMonthlyWage();
    Amazon.getMonthlyWage();
    Google.getMonthlyWage();

    System.out.println(Reliance);
    System.out.println(Amazon);
    System.out.println(Google);
  }

}
