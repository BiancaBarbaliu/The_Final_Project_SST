Feature: Checkout process on Saucedemo website

  Scenario: Proceeding to checkout
    Given the user has items in the shopping cart
    When the user clicks on the checkout button
    Then the user should be taken to the checkout step one page