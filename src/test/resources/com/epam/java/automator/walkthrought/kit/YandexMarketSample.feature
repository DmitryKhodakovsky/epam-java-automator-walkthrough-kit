Feature: Yandex Marker Sample

  Background:
    Given I am on Yandex Market page

  Scenario: Search iphone product
    When I search 'iPhone' in Search bar on Yandex Market page
    Then product titles should contain 'iPhone1' on Yandex Market Catalog page

  Scenario: Add products to compare
    Given I open 'Ноутбуки' subcategory in 'Компьютеры' category in Top level menu on the Yandex Market page
    When I add 1,2 products to compare list on Yandex Market Catalog page
    Then added products should be displayed on Yandex Market Compare page
