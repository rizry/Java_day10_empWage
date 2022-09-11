package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final int EMP_WAGE_PER_HOUR = 20;
  final int FULL_TIME_HRS = 8;
  final int PART_TIME_HRS = 4;

  int hrsWorked = 0;

  final

  @Override public String checkAttendance() {
    int attendaceNum = RandomUtil.getInt();

    if (attendaceNum == 1) return "Employee is present full time.";
    else if (attendaceNum == 2) return "Employee is present part time.";
    else return "Employee is absent.";
  }

  @Override
  public int getDailyWage() {
    String attendaceStr = checkAttendance();
    System.out.println(attendaceStr);

    if (attendaceStr.contains("full time")) hrsWorked = FULL_TIME_HRS;
    else if (attendaceStr.contains("part time")) hrsWorked = PART_TIME_HRS;

    int dailyWage = EMP_WAGE_PER_HOUR * hrsWorked;

    return dailyWage;

  }

}
