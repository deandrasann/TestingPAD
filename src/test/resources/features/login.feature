Feature: Login functionality

  Scenario: Apoteker logs in with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Apoteker fails to login with invalid credentials
    Given User is on the login page
    When User enters valid username "john_doe"
    And User enters invalid password "john123"
    And User clicks the login button
    Then An error message "Login gagal. Username atau password salah." should be displayed
