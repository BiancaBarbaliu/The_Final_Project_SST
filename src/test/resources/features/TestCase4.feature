Feature: Product sorting on Saucedemo website

  Scenario: Sorting products by price (low to high)
    Given the user is on the product page Test4
    When the user selects sort by price low to high
    Then the Products should be displayed in ascending order of price