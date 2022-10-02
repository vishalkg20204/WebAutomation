Feature: TV Home Page

  @test
  Scenario: Amazon | Select the second highest Samsung TV and verify it's description.
    Given navigate to Tv Page
    Then scroll down the page to Brand filter
    And select Samsung as brand
    Then sort By High to Low option and verify if sorting done
    Then click on second item and verify it's description.

