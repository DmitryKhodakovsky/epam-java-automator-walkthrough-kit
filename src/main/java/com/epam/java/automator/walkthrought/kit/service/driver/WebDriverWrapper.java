package com.epam.java.automator.walkthrought.kit.service.driver;

import com.epam.java.automator.walkthrought.kit.service.util.LoggerConstants;
import com.epam.java.automator.walkthrought.kit.service.util.TimeUtils;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
@Slf4j
public class WebDriverWrapper implements WebDriver {

  private final WebDriver driver;

  @Override
  public void get(String url) {
    log.debug(String.format("Open url: %s", url));
    long startTime = System.currentTimeMillis();
    try {
      driver.navigate().to(url);
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Open_Page",
          TimeUtils.getOperationExecutionTime(startTime), url));
    }
  }

  @Override
  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  @Override
  public String getTitle() {
    return driver.getTitle();
  }

  @Override
  public List<WebElement> findElements(By by) {
    log.debug(String.format("Finding elements by %s", by));
    long startTime = System.currentTimeMillis();
    try {
      return driver.findElements(by);
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Find_Elements",
          TimeUtils.getOperationExecutionTime(startTime), by));
    }
  }

  @Override
  public WebElement findElement(By by) {
    log.debug(String.format("Finding element by %s", by));
    long startTime = System.currentTimeMillis();
    try {
      return driver.findElement(by);
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Find_Element",
          TimeUtils.getOperationExecutionTime(startTime), by));
    }
  }

  @Override
  public String getPageSource() {
    return driver.getPageSource();
  }

  @Override
  public void close() {
    log.debug("Driver close");
    long startTime = System.currentTimeMillis();
    try {
      driver.close();
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Driver_Close",
          TimeUtils.getOperationExecutionTime(startTime), ""));
    }
  }

  @Override
  public void quit() {
    log.debug("Driver quit");
    long startTime = System.currentTimeMillis();
    try {
      driver.quit();
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Driver_Quit",
          TimeUtils.getOperationExecutionTime(startTime), ""));
    }
  }

  @Override
  public Set<String> getWindowHandles() {
    return driver.getWindowHandles();
  }

  @Override
  public String getWindowHandle() {
    return driver.getWindowHandle();
  }

  @Override
  public TargetLocator switchTo() {
    return driver.switchTo();
  }

  @Override
  public Navigation navigate() {
    return driver.navigate();
  }

  @Override
  public Options manage() {
    return driver.manage();
  }

  /**
   * Take screenshot of the page
   *
   * @return byte array
   */
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
