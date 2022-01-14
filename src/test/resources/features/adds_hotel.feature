@addHotel
Feature: Add Hotel Scenerios

  @success
  Scenario Outline: adds hotel when filled w<ith correct values
    Given I am on Add Hotel Page
    When I fill in hotel name field with <hotelName>
    And I fill in hotel city field with <city>
    And I fill in hotel location field with <location>
    And I fill in hotel price field with <price>
    And I select image from library
    And I check a hotel attribute
    # And I check box
    And I fill in license no field with <licenseNo>
    And I fill in business license no field with <businessLicenseNo>
    And I click on Add Hotel button expecting failure
    # Then I should see the not found warning
    # And I should see the same page I am on
    Examples:
      | city            | hotelName     | location    | price   | licenseNo | businessLicenseNo |
      |  Antalya        | Berrak Otel   | ABC caddesi | 300     | 232342211 | 233423343         |



  Scenario: adding hotel fails when i don't select at least one image
    Given I am on Add Hotel Page
    When I fill in hotel name field with Antalya
    And I fill in hotel city field with Berrak Otel
    And I fill in hotel location field with ABC Caddesi
    And I fill in hotel price field with 300
    And I check a hotel attribute
    But I don't select image from library
    And I fill in license no field with 232323344
    And I fill in business license no field with 45553345
    And I click on Add Hotel button expecting failure
    # Then I should see the not found warning
    # And I should see the same page I am on

  Scenario: adding hotel fails when i don't check at least one attribute
    Given I am on Add Hotel Page
    When I fill in hotel name field with Antalya
    And I fill in hotel city field with Berrak Otel
    And I fill in hotel location field with ABC Caddesi
    And I fill in hotel price field with 300
    But I don't check a hotel attribute
    And I select image from library
    And I fill in license no field with 232323344
    And I fill in business license no field with 45553345
    And I click on Add Hotel button expecting failure
    # Then I should see the not found warning
    # And I should see the same page I am on