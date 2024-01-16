Feature: Order completion on Saucedemo website

  Scenario: Completing the purchase and viewing the order success page
    Given the user is on the checkout step two page
    When the user clicks on the finish button TestCase18
    Then the user should be directed to the order success page with a unique order ID