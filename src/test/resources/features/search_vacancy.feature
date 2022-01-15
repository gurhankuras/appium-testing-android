# refactor these scenarios to make more reusable
@search
Feature: Search Hotel Scenarios

  Background: I arrive home page that the feature resides
    Given I am on Main page

  @happyPath
  Scenario: Shows available hotels after reservation search is successful
    When I fill the form with the info matching a hotel
    And I submit form
    Then I should be shown available hotels as a list in a new page

  Scenario: search fails due to entered past check-in date
    When I fill in city text field with Istanbul
    And I fill in check in date text field with 14/02/2010
    And I fill in check out date text field with 15/02/2010
    And I fill in number of person text field with 2
    And I fill in number of child text field with 2
    And I click on search button expecting failure
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario: search fails due to check-in date past check-out date
    When I fill in the search form with valid data
    But I fill in check in date text field with 16/02/2022
    And I fill in check out date text field with 12/02/2022
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario: search fails due to reservation date was exceeded
    When I fill in the search form with valid data
    But I fill in checkin date with 181 days from today
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on

  Scenario: search fails due to maximum number of person was exceeded
    Maximum number of person count is 6
    When I fill in the search form with valid data
    But I fill in number of person text field with 7
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on

  Scenario: search fails due to maximum number of child was exceeded
    Maximum number of child count is 2
    When I fill in the search form with valid data
    But I fill in number of child text field with 3
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario Outline: it does not search if any field is empty
    When I fill in city text field with <city>
    And I fill in check in date text field with <checkInDate>
    And I fill in check out date text field with <checkOutDate>
    And I fill in number of person text field with <numberOfPerson>
    And I fill in number of child text field with <numberOfChild>
    And I click on search button expecting failure
    Then I should see the empty field warning
    And I should see the same page I am on
    Examples:
      | city     | checkInDate | checkOutDate | numberOfPerson | numberOfChild |
      |          | 14/05/2022  | 15/05/2022   | 2              | 2             |
      | Istanbul |             | 15/05/2022   | 2              | 2             |
      | Istanbul | 14/05/2022  |              | 2              | 2             |
      | Istanbul | 14/05/2022  | 15/05/2022   |                | 2             |
      | Istanbul | 14/05/2022  | 15/05/2022   | 2              |               |


  Scenario: It searches with all fields filled but cannot find any hotel matching criteria
    When I fill in the search form with valid data
    But It cannot find any hotels that matches criterion
    Then I should see the not found warning
    And I should see the same page I am on



  #Scenario Outline: It searches with all fields filled but cannot find any hotel matching criteria
   # Given I want to make a reservation
    #When I fill in form with valid info
    #But I leave <field> blank
    #And I submit form
    #Then I should be shown <warning> field warning
    #And I should be shown reservation form page
    #Examples:
    #  | field     | warning |
    #  | istanbul | 14/05/2022  |