Feature: Login page

  Background:
    Given user is on login page


    @login
    Scenario: Verify user can login to System with valid credentials
      When user type "jwk31" in username input field
      And user type "Samsung103110" in password input field
      And user click on login button
      Then user should successfully land to Home page