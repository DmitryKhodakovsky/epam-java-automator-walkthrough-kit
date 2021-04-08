package com.epam.java.automator.walkthrought.kit.steps;

import static org.assertj.core.api.Assertions.assertThat;


import com.epam.java.automator.walkthrought.kit.service.page.objects.YandexMarketCatalogPage;
import io.cucumber.java.en.Then;
import java.util.List;
import org.assertj.core.api.SoftAssertions;

public class ThenSteps {

  @Then("product titles should contain {string} on Yandex Market Catalog page")
  public void productTitlesShouldContainText(String expectedText) {
    List<String> actualText = new YandexMarketCatalogPage().getProductTitles();
    SoftAssertions sa = new SoftAssertions();
    actualText.forEach(text -> sa.assertThat(text)
        .as(String.format("Product titles list does not contain '%s' in title", expectedText))
        .contains(expectedText));
    sa.assertAll();
  }
}
