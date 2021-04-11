package com.epam.java.automator.walkthrought.kit.service.page.objects;

import com.epam.java.automator.walkthrought.kit.service.page.elements.ProductCardElement;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketCatalogPage extends YandexMarketBasePage {

  @FindBy(css = "[data-autotest-id='product-snippet']")
  private List<WebElement> products;

  @FindBy(xpath = "//a/span[text()='Сравнить']")
  private WebElement compareButton;

  public String addProductToCompare(int index) {
    return addProductToCompare(new ProductCardElement(products.get(index - 1)));
  }

  public void clickCompareButton() {
    click(compareButton);
  }

  private String addProductToCompare(ProductCardElement productCard) {
    productCard.clickAddToCompareButton();
    return productCard.getTitle();
  }
}
