Feature: Performance glitch simulation on Saucedemo website

  Scenario: Experiencing slow performance with a performance_glitch_user account
    Given the user is on the Saucedemo login page TestCase23
    When the user logs in with the "performance_glitch_user" credentials
    Then the user should experience slow performance in page loading or processing