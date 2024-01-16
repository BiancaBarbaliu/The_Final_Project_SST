Feature: Product interaction on Saucedemo website

  Scenario: Adding multiple products to the shopping cart
    Given the user is on the product page TestCase13
    When the user adds multiple products to the shopping cart
    Then all selected products should be present in the shopping cart