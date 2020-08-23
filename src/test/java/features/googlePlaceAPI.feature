#   | name2 |     7 | Fail    |
Feature: Validate Google Place API's
  This feature file consists all scenario's to validate Google Place API

  Scenario Outline: Validate Add Place API
    Given I have Add Place Payload with name as "<place_name>"
    When I hit "AddPlaceAPI" with HTTP "POST" method
    Then I get status code as "200"
    And key "status" in response is the value "OK"
    And key "scope" in response is the value "APP"

    Examples: 
      | place_name    |
      | appu mansion  |
      | shivu mansion |

   Scenario: Validate Get Place API
    Given I have  Place ID
    When I hit "GetPlaceAPI" with HTTP "GET" method
    Then I get status code as "200"

