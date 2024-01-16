Feature: Product sorting and filtering on Saucedemo website

  Scenario: Sorting products by name (Z to A)
    Given the user is on the product page TestCase19
    When the user selects sort by name from Z to A
    Then the products should be displayed in descending alphabetical order
