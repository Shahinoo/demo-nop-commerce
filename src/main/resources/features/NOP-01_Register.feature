@smoke @build
Feature: Register | users could register with new accounts

  Scenario: user could register with valid data successfully
    Given user go to register page
    When user select gender type male
    And user enter first name "Shah" and last name "tester"
    And user enter date of birth
      | day | month   | year |
      | 15  | October | 1995 |
    And user enter email field
    And  user fills Password fields "P@ssw0rdO" and "P@ssw0rdO"
    And user clicks on register button
    Then Success message is displayed
