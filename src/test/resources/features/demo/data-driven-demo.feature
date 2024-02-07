@data
Feature: Data Driven Demo Test

  Scenario: Single Table as Maps
    Given a data table is provided below
      | first name | last name | age |
      | Robert     | Stone     |  45 |
      | Mary       | Sue       |  21 |
    When the data is taken
    Then the result is displayed

  @test
  Scenario: In Line Data
    Given the age is 5
    When the age is verified
    Then the drinking test is done
