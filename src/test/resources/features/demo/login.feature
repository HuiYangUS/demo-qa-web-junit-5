@login
Feature: Login

  @ui
  Scenario: Entered password is not visible
    Given user is on the login page
    When user enters the password
    Then user does not see a visible password

  @ui @test
  Scenario: Positive login test
    Given user is on the login page
    When user enters the username
    And user enters the password
    And user clicks the [Login] button
    Then user is on the inventory page
