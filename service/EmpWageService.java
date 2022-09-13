package com.empwage.service;

import com.empwage.service.impl.CompanyEmpWage;

public interface EmpWageService {

  void addCompanyEmpWage(String company, short empRatePerHour, short numOfWorkingDays, int maxHoursPerMonth);

  void getMonthlyWage();

  short getMonthlyWage(CompanyEmpWage c);

  short getDailyWage(short empWagePerHr);

  String checkAttendance();
}
