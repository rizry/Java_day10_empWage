package com.empwage;

import com.empwage.service.EmpWageService;
import com.empwage.service.impl.EmpWageServiceImpl;

public class EmpWageComputationController {

  public static void main(String[] args) {
    System.out.println("--Welcome to Employee Wage Computation Program--");

    EmpWageService Emp = new EmpWageServiceImpl();

    System.out.println("Employee's today's wage: " + Emp.getDailyWage());
  }

}
