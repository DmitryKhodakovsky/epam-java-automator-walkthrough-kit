package com.epam.java.automator.walkthrought.kit.service.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeUtils {

  /**
   * Get execution time of action.
   *
   * @param startTime - start time
   * @return execution time im ms
   */
  public static String getOperationExecutionTime(final long startTime) {
    return String.valueOf(System.currentTimeMillis() - startTime);
  }
}
