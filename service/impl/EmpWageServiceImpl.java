package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {
  final short EMP_WAGE_PER_HOUR = 20;
  final byte FULL_TIME_HRS = 8;
  final byte PART_TIME_HRS = 4;

  short hrsWorked = 0;

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
    short monthlyWage = 0;
    short daysWorked;

    System.out.print("Employee's daily wage: ");

    for (daysWorked = 0; daysWorked < 20;) {

			short dailyWage = getDailyWage(); //getting employee's daily wage for each day
			System.out.print(dailyWage + " ");

			if (dailyWage > 0) { //checking if the employee is present i.e. has dailyWage>0
        monthlyWage += dailyWage;
					daysWorked++; //only increasing number of days worked if the employee HAS worked, either full time or part time
        }
      }
      System.out.println();

      return monthlyWage;

    }

}
