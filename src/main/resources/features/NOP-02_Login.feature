@smoke
Feature: NOP-02 Login | users could use Login functionality

  Scenario: user could login with valid email and password
    Given user go to register page
    When User do registration
    Then Success message is displayed
    When user go to login page
    And user login with valid email and password
    And user press on login button
    Then user login to the system successfully

  Scenario: user could login with invalid email and password
    Given user go to login page
    When user login with invalid "wrong@gmail.com" and "P@ssw0rd"
    And user press on login button
    Then user could not login to the system
