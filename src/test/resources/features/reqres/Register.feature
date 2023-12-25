Feature: Registration User
@Tugas
  Scenario Outline: Registration user with valid email and password
    Given Post registration user with json "<json>"
    When Send request registration post registration user
    Then Status code should be 200
    And Validate json schema "<jsonSchema>"
  Examples:
    | json              | jsonSchema              |
    | RegisterUser.json | RegisterUserSchema.json |

@Tugas
Scenario: Registration user with invalid email and password
  Given Post registration with json "RegisterUserInvalid.json"
  When Send request registration post registration user
  Then Status code should be 400
  And Validate json schema "RegisterUserInvalidSchema.json"