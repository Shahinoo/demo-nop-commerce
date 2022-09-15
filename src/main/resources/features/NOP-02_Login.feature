@smoke
Feature: NOP-02 Login | users could use Login functionality

  Background: User is already Registered before
    Given user go to register page
    When User do registration
      | fName | lName | email       | password | confirmPassword |
      | mush  | test  | RandomEmail | p@ssw0rd | p@ssw0rd        |
    Then Success message is displayed
    When user logout
    Then user on home page

  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with valid email and "P@ssw0rd"
    And user press on login button
#    Then user login to the system successfully
#
#  Scenario: user could login with valid email and password
#    Given user go to login page
#    When user login with invalid email and "P@ssw0rd"
#    And user press on login button
#    Then user could not login to the system
