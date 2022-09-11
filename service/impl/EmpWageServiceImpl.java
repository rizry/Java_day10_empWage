package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final short EMP_WAGE_PER_HOUR = 20;
  final byte FULL_TIME_HRS = 8;
  final byte PART_TIME_HRS = 4;
  final byte HRS_TO_WORK = 100;
  final byte DAYS_TO_WORK = 20;

  short monthlyWage;
  short hrsWorked;

  @Override
  public String checkAttendance() {
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
  public short getDailyWage() {
    String attendaceStr = checkAttendance();

    switch (attendaceStr) {
      case "present part time":
        hrsWorked = PART_TIME_HRS;
        break;

      case "present full time":
        hrsWorked = FULL_TIME_HRS;
        break;

    }

    short dailyWage = (short) (EMP_WAGE_PER_HOUR * hrsWorked);

    return dailyWage;

  }

  @Override
  public short getMonthlyWage() {
    short hrsWorked = 0;
    short daysWorked = 0;

    System.out.print("Employee's daily wage: ");

    do {
      short dailyWage = getDailyWage(); //getting employee's daily wage for each day
      System.out.print(dailyWage + " ");
      monthlyWage += dailyWage;

      String str = (dailyWage == 0) ? "absent" : dailyWage / EMP_WAGE_PER_HOUR == FULL_TIME_HRS ? "full time" : "part time";

      switch (str) {
        case "full time":
          hrsWorked += 8;
          daysWorked++;
          break;
        case "part time":
          hrsWorked += 4;
          daysWorked++;
          break;
      }

    } while (daysWorked < DAYS_TO_WORK && hrsWorked < HRS_TO_WORK);

    System.out.println("\nEmployee has worked " + hrsWorked + " hours in " + daysWorked + " days this month.");

    return monthlyWage;

  }

}
