Feature: Show Hotels that has a room that satisfies related info entered by user

  Scenario: User should see summary hotel info
    Summary info includes
      - thumbnail
      - hotel name
      - price
      - location
    Given I am shown available hotels
    Then I see all of the summary info