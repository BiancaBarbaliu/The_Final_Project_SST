Feature: Order confirmation on Saucedemo website

  Scenario: Completing the purchase
    Given the user is on the checkout step two page TestCase10
    When the user clicks on the finish button
    Then the user should see an order confirmation with a thank you message