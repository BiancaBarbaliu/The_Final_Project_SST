Feature: Product browsing on Saucedemo website

  Scenario: Viewing the list of available products
    Given the user is logged in to the Saucedemo
    When the user navigates to the product page
    Then the list of products should be displayed