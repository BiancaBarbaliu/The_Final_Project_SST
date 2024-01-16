Feature: Adding products to the cart on Saucedemo website

  Scenario: Adding a single product to the shopping cart
    Given the user is on the product page TestCase6
    When the user clicks on the "Add to cart" button for a product
    Then the product should be added to the cart