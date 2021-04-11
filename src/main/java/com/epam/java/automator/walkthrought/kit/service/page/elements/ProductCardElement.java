package com.epam.java.automator.walkthrought.kit.service.page.elements;

import com.epam.java.automator.walkthrought.kit.service.page.BasePageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCardElement extends BasePageElement {

  private WebElement rootElement;
  private WebDriverWait wait;

  public ProductCardElement(WebElement rootElement) {
    super();
    this.rootElement = rootElement;
    this.wait = new WebDriverWait(driver, 10);
  }

  public ProductCardElement clickAddToCompareButton() {
    WebElement addToCompare =
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(rootElement,
            By.xpath(".//div[contains(@aria-label, 'сравнению')]")));
    new Actions(driver.getDriver())
        .moveToElement(addToCompare)
        .click()
        .build()
        .perform();
    return this;
  }

  public String getTitle() {
    return wait.until(ExpectedConditions.visibilityOf(rootElement
        .findElement(By.xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
  }
}
