@search
Feature: Search Hotel Scenarios

    Scenario: search fails due to entered past check-in date
    Given I am on Main page
    When I fill in city text field with Istanbul
    And I fill in check in date text field with 14/02/2010
    And I fill in check out date text field with 15/02/2010
    And I fill in number of person text field with 2
    And I fill in number of child text field with 2
    And I click on search button expecting failure
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario: search fails due to check-in date past check-out date
    Given I am on Main page
    When I fill in city text field with Istanbul
    And I fill in check in date text field with 16/02/2022
    And I fill in check out date text field with 12/02/2022
    And I fill in number of person text field with 2
    And I fill in number of child text field with 2
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario: search fails due to reservation date was exceeded
    Given I am on Main page
    When I fill in city text field with Istanbul
    And I fill in check in date text field with MARK_CURRENT_DATE_PLUS_181_DAYS
    And I fill in check out date text field with MARK_CURRENT_DATE_PLUS_181_DAYS
    And I fill in number of person text field with 2
    And I fill in number of child text field with 2
    And I click on search button expecting failure
    # change this
    Then I should see the not found warning
    And I should see the same page I am on


  Scenario Outline: it does not search if any field is empty
    Given I am on Main page
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


  Scenario Outline: It searches with all fields filled but cannot find any hotel matching criteria
    Given I am on Main page
    When I fill in city text field with <city>
    And I fill in check in date text field with <checkInDate>
    And I fill in check out date text field with <checkOutDate>
    And I fill in number of person text field with <numberOfPerson>
    And I fill in number of child text field with <numberOfChild>
    And I click on search button expecting failure
    Then I should see the not found warning
    And I should see the same page I am on
    Examples:
    | city     | checkInDate | checkOutDate | numberOfPerson | numberOfChild |
    | istanbul | 14/05/2022  | 15/05/2022   | 2              | 2             |
