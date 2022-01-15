Feature: Reservation
  @happyPath
  Scenario: Should book when everything is right
    Given I want to book
    And I am shown reservation form
    When I filled the form with correct info
    And I submit form f
    Then I am shown home page

    Scenario: Should see text field when i want to make a request
      Given I want to book
      And I am shown reservation form
      When I want to make a request
      Then I should see request text field

