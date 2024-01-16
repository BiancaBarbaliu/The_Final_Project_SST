Feature: Logout functionality of Saucedemo website

  Scenario: Logging out of the application
    Given the user is logged in to the Saucedemo TestCase11
    When the user clicks on the logout link in the sidebar menu
    Then the user should be logged out and redirected to the login page