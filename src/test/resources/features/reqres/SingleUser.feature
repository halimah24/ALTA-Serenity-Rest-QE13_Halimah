Feature: Get Single User
  @Tugas
  Scenario Outline: Get single user valid page and json schema
    Given Get single user with page "<page>"
    When Send request get single user
    Then Status code should be 200
    And Validate json schema "SingleUserSchema.json"
    Examples:
      | page |
      | 1    |
    @Tugas
    Scenario Outline: : Get single user not found page and json schema
      Given Get single user not found with page "<page>"
      When Send request get single not found user
      Then Status code should be 404
      And Validate json schema "GetSingleUserNotFound.json"
      Examples:
        | page |
        | 1    |