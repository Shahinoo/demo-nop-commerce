@smoke
Feature: NOP-07 Follow us
  Scenario: user opens facebook page
    When user click on facebook link
    Then facebook page is opened on a new tab

  Scenario: user opens twitter page
    When user click on twitter link
    Then twitter page is opened on a new tab

  Scenario: user opens RSS page
    When user click on RSS link
    Then RSS page is opened on a new tab

  Scenario: user opens youTube page
    When user click on youTube link
    Then youTube page is opened on a new tab
