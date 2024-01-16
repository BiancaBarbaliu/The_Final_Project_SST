Feature: Order completion on Saucedemo website

  Scenario: Viewing order summary before finalizing the purchase
    Given the user is on the checkout step two page TestCase17
    When the user reviews the order summary
    Then the order summary should list all items, payment details, and the total cost