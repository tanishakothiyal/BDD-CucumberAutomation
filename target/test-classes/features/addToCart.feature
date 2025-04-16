Feature: Add to Cart Functionality

  Scenario: User selects colour and size and adds product to cart
    Given User should be on the account page
    When User navigates to the homepage
    And User selects a product from the listing
    And User selects size "M"
    And User selects color "Blue"
    And User clicks on Add to Cart button
    Then Product should be added with color "Blue" and size "M"
    And Cart icon should show 1 item