Feature: Login functionality of Saucedemo website

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the Saucedemo login page
    When the user enters invalid username and password
    And the user clicks the login button
    Then the user should see an error message