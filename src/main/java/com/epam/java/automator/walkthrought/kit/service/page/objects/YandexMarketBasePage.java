package com.epam.java.automator.walkthrought.kit.service.page.objects;

import com.epam.java.automator.walkthrought.kit.service.page.BasePageElement;
import com.epam.java.automator.walkthrought.kit.service.page.elements.SearchBarElement;
import lombok.Getter;

public abstract class YandexMarketBasePage extends BasePageElement {

  @Getter
  private SearchBarElement searchBar;

  protected YandexMarketBasePage() {
    searchBar = new SearchBarElement();
  }
}
