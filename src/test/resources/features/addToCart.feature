Feature: Add to cart with product variants

  As a customer
  I want to select product variants like colour and size
  So that I can add the specific product I want to the cart

  Scenario Outline: User selects colour and size and adds product to cart
    Given the user is on the Product Detail Page
    When the user selects the colour "<colour>"
    And the user selects the size "<size>"
    And the user clicks on the "<buttonName>" button
    Then the product with colour "<colour>" and size "<size>" should be added to the cart
    And the cart icon should show <itemCount> item
    And the user should see a success message confirming the product was added

    Examples:
      | colour | size | buttonName  | itemCount |
      | Orange  | M    | Add to Cart | 1         |