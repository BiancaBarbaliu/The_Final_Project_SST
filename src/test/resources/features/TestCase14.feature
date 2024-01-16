Feature: Product interaction on Saucedemo website

  Scenario: Removing a product from the shopping cart
    Given the user has added products to the cart TestCase14
    When the user removes a product from the cart
    Then the product should no longer be visible in the shopping cart
