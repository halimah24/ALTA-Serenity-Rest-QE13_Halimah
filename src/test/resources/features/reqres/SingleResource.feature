Feature: Single Resource User
  @Tugas
  Scenario Outline: Single Resource User with valid param id
    Given Get single resource user with id <id>
    When Send request get single resource user
    Then Status code should be 200
    And Response body data_id should be <id>
    And Validate get single resource json schema "SingleResource.json"
    Examples:
      | id |
      | 1  |
    Scenario Outline: Single Resource Not Found with valid param id
      Given Get single resource user with id <id>
      When Send request get single resource user
      Then Status code should be 404
      Examples:
        | id |
        | 23 |
