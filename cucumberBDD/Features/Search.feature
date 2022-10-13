@JustEat
Feature: Use the website to find restaurants

Scenario Outline: Search for restaurants in an area
Given I am on Justeat.ca application
And I want food in "WC2N 5DU"
When I search for restaurants
Then I should see some restaurants in "WC2N 5DU"