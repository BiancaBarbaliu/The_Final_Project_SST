Feature: Checkout information validation on Saucedemo website

  Scenario: Attempting to continue checkout with missing information
    Given the user is on the checkout step one page TestCase16
    When the user attempts to continue without entering payment information
    Then the user should be prompted to fill in all required fields