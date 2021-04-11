package com.epam.java.automator.walkthrought.kit.steps;

import com.epam.java.automator.walkthrought.kit.service.driver.DriverSingleton;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketCategoryPage;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketHomePage;
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

  @Given("I open {string} subcategory in {string} category in Top level menu on the Yandex Market page")
  public void openSubcategoryInCategoryInTopLevelMenuOnTheYandexMarketPage(String subcategory,
                                                                           String category) {
    new YandexMarketHomePage().openCategory(category);
    new YandexMarketCategoryPage().openSubcategory(subcategory);
  }
}
