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

    switch (attendaceNum) {
      case 0:
        return "absent";
      case 1:
        return "present full time";
      case 2:
        return "present part time";

      default:
        return "Invalid.";
    }

  }

  @Override
  public int getDailyWage() {
    String attendaceStr = checkAttendance();
    System.out.println("Employee is " + attendaceStr);

    switch (attendaceStr) {
      case "present part time":
        hrsWorked = PART_TIME_HRS;
        break;

      case "present full time":
        hrsWorked = FULL_TIME_HRS;
        break;
    }

    int dailyWage = EMP_WAGE_PER_HOUR * hrsWorked;

    return dailyWage;

  }

}
