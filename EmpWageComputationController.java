package com.empwage;

import com.empwage.service.EmpWageService;
import com.empwage.service.impl.EmpWageServiceImpl;

public class EmpWageComputationController {

		public static void main(String[] args) {
				System.out.println("--Welcome to Employee Wage Computation Program--");

				EmpWageService empWageBuilder = new EmpWageServiceImpl();

				empWageBuilder.addCompanyEmpWage("Reliance", (short) 20, (short) 100, (byte) 20);
				empWageBuilder.addCompanyEmpWage("Amazon", (short) 30, (short) 120, (byte) 25);
				empWageBuilder.addCompanyEmpWage("Google", (short) 50, (short) 130, (byte) 25);

				empWageBuilder.getMonthlyWage();
		}

}
