Feature: List Resource User
  @Tugas
  Scenario Outline: List Resource User with valid param page
    Given Get list resource user with page <id>
    When Send request get list resource user
    Then Status code should be 200
    And Response body page should be <id>
    And Validate get list resource json schema "ListResource.json"
    Examples:
      | id |
      | 1 |