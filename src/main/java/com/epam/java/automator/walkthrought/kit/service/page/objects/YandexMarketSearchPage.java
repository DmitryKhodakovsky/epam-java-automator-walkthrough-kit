package com.epam.java.automator.walkthrought.kit.service.page.objects;

import com.epam.java.automator.walkthrought.kit.service.page.elements.ProductCardElement;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketSearchPage extends YandexMarketBasePage {

  @FindBy(css = "[data-autotest-id='product-snippet']")
  private List<WebElement> products;

  public List<String> getProductTitles() {
    return products
        .stream()
        .map(ProductCardElement::new)
        .map(ProductCardElement::getTitle)
        .collect(Collectors.toList());
  }
}
