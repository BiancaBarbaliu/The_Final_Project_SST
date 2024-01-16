Feature: Product sorting and filtering on Saucedemo website

  Scenario: Sorting products by name (A to Z)
    Given the user is on the product page TestCase20
    When the user selects sort by name from A to Z
    Then the products should be displayed in ascending alphabetical order
