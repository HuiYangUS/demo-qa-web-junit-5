@sweet @dessert
Feature: Best ice cream

  @demo @data-driven
  Scenario Outline: Eating ice cream
    Given I have ice cream "<name>"
    When I check for the rating "<rating>" of this ice cream
    Then I verify that I have the "<best ice cream>"

    Examples: 
      | name      | rating | best ice cream |
      |           |      5 | chocolate      |
      | vanilla   |      7 | chocolate      |
      | chocolate |     10 | chocolate      |
