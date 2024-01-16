Feature: Navigation to external pages from Saucedemo

  Scenario: Redirecting to the Sauce Labs homepage via the About button
    Given the user is logged in and on the inventory page of Saucedemo
    When the user clicks on the "About" button in the sidebar
    Then the user should be redirected to the Sauce Labs homepage