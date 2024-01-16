Feature: Product sorting on Saucedemo website

  Scenario: Sorting products by price (high to low)
    Given the user is on the product page Test21
    When the user selects sort by price high to low
    Then the products should be displayed in descending order of price