Feature: Problematic behavior simulation on Saucedemo website
  Scenario: Experiencing unusual behavior with a problem user account
    Given the user is on the Saucedemo login page TestCase22
    When the user logs in with the "problem_user" credentials
    Then the user should experience unusual behaviors such as incorrect product details or visual glitches