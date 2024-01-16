Feature: Visual experience on Saucedemo website

  Scenario: Experiencing visual discrepancies with a visual_user account
    Given the user is on the Saucedemo login page TestCase25
    When the user logs in with the "visual_user" credentials
    Then the user should notice visual discrepancies in the product images or layouts