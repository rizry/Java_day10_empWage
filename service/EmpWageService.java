package com.empwage.service;

import com.empwage.service.impl.CompanyEmpWage;

public interface EmpWageService {

  void addCompanyEmpWage(String company, short empWagePerHr, short daysToWork, short hrsToWork);

  void getMonthlyWage();

  short getMonthlyWage(CompanyEmpWage c);

  short getDailyWage(short empWagePerHr);

  String checkAttendance();
}
