Feature: Authentication

  This feature is for login test, when a user login in the system.

  @login
  Scenario: Login sucess
    Given I visit page
    When I put credentials "tomsmith" and password "SuperSecretPassword!"
    Then screen sucess appear
