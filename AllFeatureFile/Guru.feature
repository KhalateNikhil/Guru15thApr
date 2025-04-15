Feature: Test Guru99 Application

  Scenario: Validate register page functionality
    Given user is on register page
    When user enter firstname lastname phone and email
    And user enter address city state postal code and country
    And user enter username password confirm password and click on submit button
    Then user is on success page and validate success page url

  Scenario: Validate loginpage functionality
    When user click on sign in link
    And user enter valid username, password and click on submit button
    Then user is on login successful page and validate url
    And user validate Successfully keyword in login success page
