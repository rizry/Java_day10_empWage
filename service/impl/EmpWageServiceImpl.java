package com.empwage.service.impl;

import java.util.ArrayList;
import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;
import com.empwage.utils.ScannerInput;

public class EmpWageServiceImpl implements EmpWageService {
  final byte FULL_TIME_HRS = 8;
  final byte PART_TIME_HRS = 4;
  ArrayList<CompanyEmpWage> companyEmpWageList = new ArrayList<>();

  @Override
  public void addCompanyEmpWage(String company, short empWagePerHr, short daysToWork, short hrsToWork) {
    companyEmpWageList.add(new CompanyEmpWage(company, empWagePerHr, daysToWork, hrsToWork));
  }

  @Override
  public void getWageByCompany() {
    if (companyEmpWageList.size() == 0) {
      System.out.println("add a company before getting its wage.");
      return;
    }

    String ch = "n";

    System.out.print("\nThe companies added are: ");
    for (CompanyEmpWage c : companyEmpWageList) if (c != null) System.out.print(c.name + ", ");

    do {
      System.out.print("\nEnter a company name to get its wage: ");
      String name = ScannerInput.stringValue();

      checkCompany(name);

      System.out.print("check another company wage? (y/n) ");
      ch = ScannerInput.stringValue();

    } while (ch.toLowerCase().contains("y"));

  }

  private void checkCompany(String name) {
    for (CompanyEmpWage c : companyEmpWageList) {
      if (c != null && c.name.toLowerCase().equals(name.toLowerCase())) {
        System.out.println("Total wage for " + c.name + " is " + c.monthlyEmpWage);
        return;
      }
    }
    System.out.println("There is no company " + name + " added yet.");
  }

  @Override
  public void getMonthlyWage() {

    for (CompanyEmpWage c : companyEmpWageList) {
      if (c != null) {
        c.setMonthlyEmpWage(this.getMonthlyWage(c));
        System.out.println(c);
      }
    }

  }

  @Override
  public short getMonthlyWage(CompanyEmpWage c) {

    short monthlyWage = 0, daysWorked = 0, hrsWorked = 0;

    do {
			short dailyWage = getDailyWage(c.empWagePerHr); //getting employee's daily wage for each day
			monthlyWage += dailyWage;
			c.addDailyEmpWage(dailyWage);

			String str = (dailyWage == 0) ? "absent" : dailyWage / c.empWagePerHr == FULL_TIME_HRS ? "full time" : "part time";

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

    } while (daysWorked < c.daysToWork && hrsWorked < c.hrsToWork);

    return monthlyWage;

  }

  @Override
  public short getDailyWage(short empWagePerHr) {
    String attendaceStr = checkAttendance();
    short hrsWorked = 0;

    switch (attendaceStr) {
    case "present part time":
      hrsWorked = PART_TIME_HRS;
      break;

    case "present full time":
      hrsWorked = FULL_TIME_HRS;
      break;

    default:
      hrsWorked = 0;
    }

    short dailyWage = (short) (empWagePerHr * hrsWorked);

    return dailyWage;

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

}
