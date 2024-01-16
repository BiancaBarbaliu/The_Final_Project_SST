Feature: Payment functionality on Saucedemo website

  Scenario: Filling in payment information
    Given the user is on the checkout step one page
    When the user enters payment information
    And the user clicks on the continue button
    Then the user should be taken to the checkout step two page