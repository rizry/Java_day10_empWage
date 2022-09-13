package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final byte FULL_TIME_HRS = 8;
  final byte PART_TIME_HRS = 4;
  String name;
  short empWagePerHr;
  byte daysToWork;
  short hrsToWork;

  short monthlyWage;
  short daysWorked;
  short hrsWorked;

  public EmpWageServiceImpl(String name, short empWagePerHr, short hrsToWork, byte daysToWork) {
    this.name = name;
    this.empWagePerHr = empWagePerHr;
    this.hrsToWork = hrsToWork;
    this.daysToWork = daysToWork;

  }

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
    short hrsWorked = 0;

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
  public short getMonthlyWage() {

    do {
			short dailyWage = getDailyWage(); //getting employee's daily wage for each day
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

    return monthlyWage;

  }

  @Override
  public String toString() {
    return "Employee at " + name + " worked " + hrsWorked + " hours in " + daysWorked + " days this month.\nAnd made "
    + monthlyWage + "$\n";

  }

}
