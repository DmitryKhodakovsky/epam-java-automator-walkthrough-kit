package com.epam.java.automator.walkthrought.kit.service.page;

import com.epam.java.automator.walkthrought.kit.service.driver.DriverSingleton;
import com.epam.java.automator.walkthrought.kit.service.driver.WebDriverWrapper;
import com.epam.java.automator.walkthrought.kit.service.util.LoggerConstants;
import com.epam.java.automator.walkthrought.kit.service.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class BasePageElement {

  private static final long TIMEOUT_IN_SECONDS = 10;

  protected WebDriverWrapper driver;

  protected BasePageElement() {
    this.driver = DriverSingleton.getDriver();
    PageFactory.initElements(driver, this);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }

  protected void click(WebElement webElement) {
    long startTime = System.currentTimeMillis();
    try {
      waitForElementToBeClickable(webElement);
      webElement.click();
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Click",
          TimeUtils.getOperationExecutionTime(startTime), driver.getCurrentUrl()));
    }
  }

  protected void sendKeys(WebElement webElement, String message) {
    long startTime = System.currentTimeMillis();
    try {
      waitForElementIsVisible(webElement);
      webElement.clear();
      webElement.sendKeys(message);
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Send_Keys",
          TimeUtils.getOperationExecutionTime(startTime), driver.getCurrentUrl()));
    }
  }

  protected String getText(WebElement webElement) {
    long startTime = System.currentTimeMillis();
    String text;
    try {
      waitForElementIsVisible(webElement);
      text = webElement.getText();
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Get_Text",
          TimeUtils.getOperationExecutionTime(startTime), driver.getCurrentUrl()));
    }
    return text;
  }

  protected void waitForElementToBeClickable(WebElement element) {
    long startTime = System.currentTimeMillis();
    try {
      new WebDriverWait(driver.getDriver(), TIMEOUT_IN_SECONDS)
          .until(ExpectedConditions.elementToBeClickable(element));
    } finally {
      log.info(String.format(LoggerConstants.LOG_EXECUTION_TIME, "Wait_For_Element_To_Be_Clickable",
          TimeUtils.getOperationExecutionTime(startTime), driver.getCurrentUrl()));
    }
  }

  protected void waitForElementIsVisible(WebElement element) {
    new WebDriverWait(driver.getDriver(), TIMEOUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

}
