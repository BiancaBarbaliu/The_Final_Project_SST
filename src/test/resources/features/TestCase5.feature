Feature: Product details on Saucedemo website

  Scenario: Viewing details of a specific product
    Given the user is on the product page
    When the user clicks on a product's name
    Then the product's details should be displayed