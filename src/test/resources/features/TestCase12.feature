Feature: Invalid login attempt handling on Saucedemo website

  Scenario: Attempt to login with a locked-out user account
    Given the user is on the Saucedemo login page TestCase12
    When the user tries to login with a locked-out user account
    Then the user should receive a locked-out user error message