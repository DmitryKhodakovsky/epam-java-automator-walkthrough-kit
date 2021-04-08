package com.epam.java.automator.walkthrought.kit.steps;

import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketHomePage;
import io.cucumber.java.en.When;

public class WhenSteps {

  @When("I search {string} in Search bar on Yandex Market page")
  public void searchInSearchBarOnYandexMarketPage(String searchItem) {
//    DriverSingleton.getDriver().findElement(By.id("header-search")).sendKeys(searchItem);
    YandexMarketHomePage homePage = new YandexMarketHomePage();
    homePage.getSearchBar().sendKeysToSearchInput(searchItem);
    homePage.getSearchBar().clickToSearchButton();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
