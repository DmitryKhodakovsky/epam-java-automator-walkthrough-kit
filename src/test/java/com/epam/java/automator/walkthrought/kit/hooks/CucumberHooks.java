package com.epam.java.automator.walkthrought.kit.hooks;

import com.epam.java.automator.walkthrought.kit.service.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class CucumberHooks {

  @Before
  public void setUp(Scenario scenario) {
    MDC.put("scenarioName", scenario.getName());
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      byte[] screenshot = DriverSingleton.getDriver().takeScreenshot();
      Allure.getLifecycle().addAttachment("failed_screenshot", "image/png", "png", screenshot);
      String pageSource = DriverSingleton.getDriver().getPageSource();
      Allure.addAttachment("failed_page_source", "text/html", pageSource, "html");
    }
    DriverSingleton.closeDriver();
  }

}
