Feature: Login functionality of Saucedemo website

  Scenario: Successful login with valid credentials
    Given the user is on the Saucedemo login page on Test1
    When the user enters valid username and password
    And the user clicks the login button on Test1
    Then the user should be redirected to the product page