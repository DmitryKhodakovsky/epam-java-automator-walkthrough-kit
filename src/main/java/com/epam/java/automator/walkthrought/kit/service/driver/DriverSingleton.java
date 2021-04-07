package com.epam.java.automator.walkthrought.kit.service.driver;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.remote.BrowserType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverSingleton {

  private static WebDriverWrapper driver;

  public static WebDriverWrapper getDriver() {
    if (Objects.isNull(driver)) {
      final String browserName = System.getProperty("browser.name", BrowserType.CHROME);
      driver = new WebDriverWrapper(WebDriverFactory.createDriver(browserName));
    }
    driver.manage().window().maximize();
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
