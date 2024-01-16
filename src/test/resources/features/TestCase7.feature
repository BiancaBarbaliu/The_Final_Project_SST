Feature: Cart review on Saucedemo website

  Scenario: Reviewing items in the shopping cart
    Given the user has added products to the cart
    When the user clicks on the shopping cart link
    Then the user should see all added products in the cart