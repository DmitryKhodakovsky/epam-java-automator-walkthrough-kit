package com.epam.java.automator.walkthrought.kit.steps;

import static org.assertj.core.api.Assertions.assertThat;


import com.epam.java.automator.walkthrought.kit.context.TestContext;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketCompareProductPage;
import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketSearchPage;
import io.cucumber.java.en.Then;
import java.util.List;
import org.assertj.core.api.SoftAssertions;

public class ThenSteps {

  @Then("product titles should contain {string} on Yandex Market Catalog page")
  public void productTitlesShouldContainText(String expectedText) {
    List<String> actualText = new YandexMarketSearchPage().getProductTitles();
    SoftAssertions sa = new SoftAssertions();
    actualText.forEach(text -> sa.assertThat(text)
        .as(String.format("Product titles list does not contain '%s' in title", expectedText))
        .contains(expectedText));
    sa.assertAll();
  }

  @Then("added products should be displayed on Yandex Market Compare page")
  public void addedProductsShouldBeDisplayedOnYandexMarketComparePage() {
    List<String> expectedProductTitles =
        TestContext.getInstance().getTestObject(TestContext.COMPARED_PRODUCT_TITLES);

    List<String> actualProductTitles = new YandexMarketCompareProductPage().getProductTitles();

    assertThat(actualProductTitles)
        .as("Проверка что выбранные товары добавлены в список сравнения")
        .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
  }
}
