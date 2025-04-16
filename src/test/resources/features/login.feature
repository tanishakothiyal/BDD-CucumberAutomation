Feature: User Login

  Scenario: Valid user logs in successfully
    Given User is on the login page
    When User enters valid credentials
    Then User should be on the account page