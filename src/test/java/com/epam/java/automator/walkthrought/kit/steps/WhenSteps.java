package com.epam.java.automator.walkthrought.kit.steps;

import com.epam.java.automator.walkthrought.kit.context.TestContext;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketCatalogPage;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketHomePage;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

  @When("I add {word} products to compare list on Yandex Market Catalog page")
  public void addProductsToCompareListOnTheYandexMarketCatalogPage(String productStringIds) {
    List<Integer> productIds = Arrays.stream(productStringIds.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    YandexMarketCatalogPage yandexMarketCatalogPage = new YandexMarketCatalogPage();

    List<String> productTitles = new ArrayList<>();

    productIds.forEach(
        productId -> productTitles.add(yandexMarketCatalogPage.addProductToCompare(productId)));

    TestContext.getInstance().setTestObject(TestContext.COMPARED_PRODUCT_TITLES, productTitles);

    yandexMarketCatalogPage.clickCompareButton();
  }
}
