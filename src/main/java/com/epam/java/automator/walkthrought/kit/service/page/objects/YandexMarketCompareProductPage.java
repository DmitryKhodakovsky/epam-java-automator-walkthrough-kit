package com.epam.java.automator.walkthrought.kit.service.page.objects;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketCompareProductPage extends YandexMarketBasePage {

  @FindBy(css = "[data-tid='412661c'] a.cia-cs")
  private List<WebElement> comparedProducts;

  public List<String> getProductTitles() {
    return comparedProducts
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }
}
