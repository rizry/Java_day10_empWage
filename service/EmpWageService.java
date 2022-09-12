package com.empwage.service;

public interface EmpWageService {

  String checkAttendance();

  short getDailyWage();

  short getMonthlyWage(short empWagePerHr, short hrsToWork, byte daysToWork);
}
