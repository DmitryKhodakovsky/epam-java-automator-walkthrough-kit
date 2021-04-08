package com.epam.java.automator.walkthrought.kit.service.page.elements;

import com.epam.java.automator.walkthrought.kit.service.page.BasePageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBarElement extends BasePageElement {

  @FindBy(id = "header-search")
  private WebElement searchInput;

  @FindBy(xpath = "//form[@action='/search']//button[@type='submit']")
  private WebElement searchButton;

  public void sendKeysToSearchInput(String searchItem) {
    sendKeys(searchInput, searchItem);
  }

  public void clickToSearchButton() {
    click(searchButton);
  }
}
