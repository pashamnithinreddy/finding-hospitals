Feature: doctorslist

  Scenario: verify_url
    Given user should navigate to the practo website
    When user gets the current url
    Then verify the practo page

  Scenario: verify_doctorslist
    Given user should click on find doctors
    When user selects a city
    And user a selects a doctor
    And user applies filters
    Then user should get doctors list
