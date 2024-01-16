Feature: Error handling on Saucedemo website

  Scenario: Encountering error messages with an error_user account
    Given the user is on the Saucedemo login page TestCase24
    When the user logs in with the "error_user" credentials
    Then the user should encounter error messages during site interaction