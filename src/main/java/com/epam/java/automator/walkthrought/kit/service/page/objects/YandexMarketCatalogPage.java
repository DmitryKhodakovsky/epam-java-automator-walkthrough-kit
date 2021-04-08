package com.epam.java.automator.walkthrought.kit.service.page.objects;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketCatalogPage extends YandexMarketBasePage {

  @FindBy(css = "[data-autotest-id='product-snippet'] h3")
  private List<WebElement> productTitles;

  public List<String> getProductTitles() {
    return productTitles
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }
}
