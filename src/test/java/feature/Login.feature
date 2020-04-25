Feature: Only Login

  Scenario: Login test
    Given Initialize Login
    When I click on login link
    And I Enter Username and password
    Then Click on login button
    Then I Close the browser