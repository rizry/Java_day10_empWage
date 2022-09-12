package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final byte FULL_TIME_HRS = 8;
  final byte PART_TIME_HRS = 4;
  short empWagePerHr;
  short hrsToWork;
  byte daysToWork;

  short hrsWorked;
  short monthlyWage;

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

    short dailyWage = (short) (empWagePerHr * hrsWorked);

    return dailyWage;
  }

  @Override
  public short getMonthlyWage(short empWagePerHr, short hrsToWork, byte daysToWork) {
    this.empWagePerHr = empWagePerHr;
    this.hrsToWork = hrsToWork;
    this.daysToWork = daysToWork;

    monthlyWage = 0;
    short daysWorked = 0;
    short hrsWorked = 0;

    System.out.print("Employee's daily wage: ");

    do {
			short dailyWage = getDailyWage(); //getting employee's daily wage for each day
			System.out.print(dailyWage + " ");
			monthlyWage += dailyWage;

			String str = (dailyWage == 0) ? "absent" : dailyWage / empWagePerHr == FULL_TIME_HRS ? "full time" : "part time";

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

    } while (daysWorked < daysToWork && hrsWorked < hrsToWork);

    System.out.println("Employee has worked " + hrsWorked + " hours in " + daysWorked + " days this month.");

    return monthlyWage;
  }

}
