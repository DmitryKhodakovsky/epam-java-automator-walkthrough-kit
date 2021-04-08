package com.epam.java.automator.walkthrought.kit.steps;

import com.epam.java.automator.walkthrought.kit.service.driver.DriverSingleton;
import io.cucumber.java.en.Given;

public class GivenSteps {

  @Given("I am on Yandex Market page")
  public void openYandexMarketPage() {
    DriverSingleton.getDriver().navigate().to("https://market.yandex.ru/");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
