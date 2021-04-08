package com.epam.java.automator.walkthrought.kit.service.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

  public static WebDriver createDriver(final String browserName) {
    if (BrowserType.CHROME.equalsIgnoreCase(browserName)) {
      return createChromeDriver();
    } else if (BrowserType.FIREFOX.equals(browserName)) {
      return createFirefoxDriver();
    }

    throw new IllegalArgumentException(String.format("Unsupported browser: %s", browserName));
  }

  private static WebDriver createChromeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }

  private static WebDriver createFirefoxDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }

}
