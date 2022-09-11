package com.empwage.service.impl;

import com.empwage.service.EmpWageService;
import com.empwage.utils.RandomUtil;

public class EmpWageServiceImpl implements EmpWageService {

  @Override
  public String checkAttendance() {
    boolean attendace = RandomUtil.getBoolean();
    if (attendace) return "Employee is present.";
    else return "Employee is absent.";
  }

}
