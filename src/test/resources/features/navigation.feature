Feature: Navigate through different webpages

  Background: Starting from the home page
    Given I am on the homepage

  Scenario: Going to the comments page from the homepage
    When I click on the comments link
    Then I will go to the comments page

  Scenario: Going to the pasts page from the homepage
    When I click on the past link
    Then I will go to the past page