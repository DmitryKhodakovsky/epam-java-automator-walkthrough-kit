package com.epam.java.automator.walkthrought.kit.service.page.objects;

import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMarketCategoryPage extends YandexMarketBasePage {

  @FindBy(css = "[data-zone-name='link'] a")
  private List<WebElement> subcategoriesMenu;

  public void openSubcategory(@NonNull String subcategory) {
    Optional<WebElement> selectedSubcategory = subcategoriesMenu
        .stream()
        .filter(elem -> (!elem.getText().isEmpty()
            && subcategory.equalsIgnoreCase(elem.getText())))
        .findFirst();

    selectedSubcategory.ifPresent(this::click);
  }
}
