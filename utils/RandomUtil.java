package com.empwage.utils;

import java.util.Random;

public class RandomUtil {
  private static final Random RAN = new Random();

  public static boolean getBoolean() {
    return RAN.nextBoolean();
  }
}
