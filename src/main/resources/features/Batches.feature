Feature: Batches functionality

  Background:
    Given Navigate to page "login"
    And Login using "saloni02@gmail.com" and "abc@123"

  @regression
  Scenario Outline: Create a batch and verify
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Batch"
    And Enter respective values in batch fields "<fileLocation>", "<owner>"
    And Enter description "abc"
    And Click the button "Add courses"
    And Add a course in batch
    And Click the button in batch "Create Batch"
    Then Verify batch is created/updated

    Examples:
      |module        |submodule|fileLocation                                                  |owner |
      |Manage Courses|Batches  |C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png|athena|

    @regression
    Scenario Outline: Add a course in batch and verify from batch summary
      Given Select "<module>", "<submodule>" from sidebar
      When Click actions icon of a batch
      And Select "Add Courses" from actions dropdown
      And Add a course in batch
      And Click the button "Back"
      And Click actions icon of a batch
      And Select "Batch Summary" from actions dropdown
      Then Verify added course displays in batch summary

      Examples:
      |module        |submodule|
      |Manage Courses|Batches  |

  @regression
    Scenario Outline:  Verify batch owner is selected by default
      When Expand info dropdown from navbar
      And Select "Profile" from dropdown
      Then Get email of user
      When Select "<module>", "<submodule>" from sidebar
      And Click the button "Create Batch"
      Then Verify owner of a batch is selected by default

      Examples:
      |module        |submodule|
      |Manage Courses|Batches  |


  @regression
    Scenario Outline: Edit a batch and verify
      Given Select "<module>", "<submodule>" from sidebar
      When Click actions icon of a batch
      And Select "Edit" from actions dropdown
      And Enter respective values in batch fields "<fileLocation>", "<owner>"
      And Enter description "def"
      And Click the button "Add courses"
      And Add a course in batch
      And Click the button in batch "Update Batch"
      Then Verify batch is created/updated
      And Select "Batch Summary" from actions dropdown
      Then Verify added course displays in batch summary

      Examples:
        |module        |submodule|fileLocation                                                  |owner |
        |Manage Courses|Batches  |C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png|athena|






