package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final int EMP_WAGE_PER_HOUR = 20;
  int HOURS_WORKED = 0;

  @Override
  public String checkAttendance() {
    boolean attendace = RandomUtil.getBoolean();
    if (attendace) return "Employee is present.";
    else return "Employee is absent.";
  }

  @Override
  public int getDailyWage() {
    String attendaceStr = checkAttendance();
    boolean isPresent = attendaceStr.contains("present") || attendaceStr.contains("Present");

    if (isPresent) HOURS_WORKED = 8;
    int dailyWage = EMP_WAGE_PER_HOUR * HOURS_WORKED;

    return dailyWage;
  }

}
