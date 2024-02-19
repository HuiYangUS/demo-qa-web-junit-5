@apply
Feature: BoraTech Application

  @ui @pos @test
  Scenario: Mock successful submission of application
    Given user is on the home page
    And user clicks [Apply Now] menu
    When user submits application data
      | first name    | Bruce             |
      | last name     | Wayne             |
      | date of birth | 3-30-1939         |
      | gender        |                 2 |
      | email         | myemail@email.com |
      | phone number  |        1234569999 |
      | course        | sdet              |
      | source        | website           |
    And user checks [Not A Robot] checkbox
    And user clicks [Submit] button
    Then user sees submission success display
