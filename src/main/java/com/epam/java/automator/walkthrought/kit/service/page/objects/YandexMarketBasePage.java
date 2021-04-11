package com.epam.java.automator.walkthrought.kit.service.page.objects;

import com.epam.java.automator.walkthrought.kit.service.page.BasePageElement;
import com.epam.java.automator.walkthrought.kit.service.page.elements.SearchBarElement;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class YandexMarketBasePage extends BasePageElement {

  @Getter
  private SearchBarElement searchBar;

  @FindBy(css = "[data-zone-name='category-link'] a")
  private List<WebElement> categoriesMenu;

  protected YandexMarketBasePage() {
    searchBar = new SearchBarElement();
  }

  public void openCategory(@NonNull String category) {
    Optional<WebElement> selectedCategory = categoriesMenu
        .stream()
        .filter(element -> (!element.getText().isEmpty()
            && category.equalsIgnoreCase(element.getText())))
        .findFirst();

    selectedCategory.ifPresent(this::click);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
