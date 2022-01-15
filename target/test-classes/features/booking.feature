Feature: Reservation

  Background:
    Given I want to book
    And I am shown reservation form

  @happyPath
  Scenario: Should book when everything is right
    When I fill in the form with valid data
    And I submit reservation form
    Then I am shown home page

  @happyPath
  Scenario: Should see text field when i want to make a request
    When I want to make a request
    Then I should see request text field

  Scenario Outline: Booking Form Validation
    When I fill in the form with valid data
    But I fill in <field> with <value>
    Then I should be shown error

    Examples: Name is too short
    Names are invalid if less than 2 characters
    | field | value |
    | name  | g     |
    | name  |       |

    Examples: Last name is too short
    Names are invalid if less than 2 characters
      | field    | value |
      | lastname |  h    |
      | lastname |       |

    Examples: TC is invalid
    TCs are invalid if are not exactly 11 digits
      | field    | value |
      | TC |           |
      | TC |  2345     |

    Examples: Phone number is invalid
    Phone numbers are invalid if are not exactly 11 digits
      | field | value|
      | phone |      |
      | phone | 0543 |

    Examples: Email format is invalid
    Emails must be adhere to the format xxx@xx.xx for more info...
      | field  | value                |
      | email  | gurhan               |
      | email  | gurhan@              |
      | email  | gurhankuras@hotmail  |
      | email  | gurhankuras@hotmail. |
      | email  | gu@hotmail.com       |


