Feature: Login User
  @Tugas
  Scenario Outline: Login user with valid email and password
    Given Post login user with json "<json>"
    When Send request with login user
    Then Status code should be 200
    And Validate login user json schema "<jsonSchema>"
    Examples:
      | json           | jsonSchema           |
      | LoginUser.json | LoginUserSchema.json |

    @Tugas
    Scenario Outline: Login user with invalid email and password
      Given Post login invalid user with json "<json>"
      When Send request with login user
      Then Status code should be 400
      And Validate login user json schema "<jsonSchema>"
      Examples:
        | json                  | jsonSchema           |
        | LoginUserInvalid.json | LoginUserInvalidSchema.json |