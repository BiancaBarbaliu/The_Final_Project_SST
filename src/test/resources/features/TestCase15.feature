Feature: Cart functionality on Saucedemo website

  Scenario: Accessing the shopping cart with no items added
    Given the user is logged in and on the product page
    And the user has not added any products to the cart
    When the user navigates to the shopping cart
    Then the shopping cart should display a message indicating it is empty