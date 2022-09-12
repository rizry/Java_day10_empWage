package com.empwage;

import com.empwage.service.EmpWageService;
import com.empwage.service.impl.EmpWageServiceImpl;

public class EmpWageComputationController {

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--");

    EmpWageService Emp = new EmpWageServiceImpl();

    System.out.println("Company1 employee's wage in a month: " + Emp.getMonthlyWage((short) 20, (short) 100, (byte) 20) + "\n");

    System.out.println("Company2 employee's wage in a month: " + Emp.getMonthlyWage((short) 30, (short) 120, (byte) 25) + "\n");

    System.out.println("Company3 employee's wage in a month: " + Emp.getMonthlyWage((short) 50, (short) 130, (byte) 25));
  }

}
