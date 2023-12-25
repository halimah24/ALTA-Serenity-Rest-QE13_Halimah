Feature: Modify Data User
  @Tugas

Scenario Outline: Modify name and job valid data
Given Modify name and job with json "<json>" and id parameter <id>
When Send request name and job modify
Then Status code should be 200
And Response body name was "<name>" and job was "<job>"
And Validate modify json schema "ModifyDataSchema.json"
Examples:
| name     | job           | id | json            |
| morpheus | zion resident | 1  | ModifyData.json |