Feature:Course module features

  Background:Check login to candidate module
    Given Navigate to page "login"
    And Login using "saloni02@gmail.com" and "abc@123"
    And Wait while screen loads

  @regression
    Scenario Outline:Add content without adding course info
      Given Select "<module>", "<submodule>" from sidebar
      When Click the button "<button>"
      And Click the button "Add Content"
      Then Verify the error displayed in input fields "<error>" "<mandatoryFieldCount>"

      Examples:
      |module        |submodule     |button       |error                 |mandatoryFieldCount|
      |Manage Courses|Course Library|Create Course|This Field is required|7                  |

  @regression
    Scenario Outline:Create content- positive flow
      Given Select "<module>", "<submodule>" from sidebar
      When Click the button "Add New"
      And Enter respective values in content fields "<contentTag>", "<fileType>", "<duration>", "<fileLocation>"
      And Enter description "<description>"
      And Click the button "Save & Exit"
      Then Verify content is created successfully "<contentTag>", "<duration>", "<fileType>"

      Examples:
     | module        |submodule      |  contentTag|fileType|duration|fileLocation                                                   |description|
     | Manage Courses|Content Library| Java      |Image   |01:00   |C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png|testAbc    |

  @regression
     Scenario Outline:Reset content
       Given Select "<module>", "<submodule>" from sidebar
       And Click the button "Add New"
       When Enter respective values in content fields "<contentTag>", "<fileType>", "<duration>", "<fileLocation>"
       And Enter description "<description>"
       And Click the button "RESET"
       And Click the button "Save & Exit"
       Then Verify the error displayed in input fields "<error>" "<mandatoryFieldCount>"

       Examples:
      | module        |submodule      |  contentTag|fileType|duration|fileLocation                                                   |description|error                 |mandatoryFieldCount|
      | Manage Courses|Content Library| Java      |Image   |01:00   |C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png|testAbc    |This Field is required|6                  |

  @regression
     Scenario Outline:Create assignment- positive flow
       Given Select "<module>", "<submodule>" from sidebar
       When Click the button "Add New"
       And Enter respective values in assignment fields "<assignmentTag>", "<marks>", "<duration>", "<category>", "<fileLocation>"
       And Enter assignment description "<description>"
       Then Click the button "Save & Exit"
       And Verify assignment is created "<category>", "<assignmentTag>", "<marks>"

       Examples:
       |module        |submodule         |assignmentTag|marks|duration|category|fileLocation                                                     |description|
       |Manage Courses|Assignment Library| Java        | 10  |  01:00 | Logical| C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png |abc        |

  @regression
     Scenario Outline: Reset assignment
       Given Select "<module>", "<submodule>" from sidebar
       And Click the button "Add New"
       When Enter respective values in assignment fields "<assignmentTag>", "<marks>", "<duration>", "<category>", "<fileLocation>"
       And Enter assignment description "<description>"
       And Click the button "RESET"
       And Click the button "Save & Exit"
       Then Verify the error displayed in input fields "<error>" "<mandatoryFieldCount>"

       Examples:
       |module        |submodule         |assignmentTag|marks|duration|category|fileLocation                                                     |description|error                 |mandatoryFieldCount|
       |Manage Courses|Assignment Library|Java        | 10  |  01:00 | Logical| C:\Users\saloni.nagpal\Pictures\Screenshots\Screenshot (10).png |abc        |This Field is required|7                  |

  @regression
     Scenario Outline: Edit content (positive flow)
       Given Select "<module>", "<submodule>" from sidebar
       When Click Actions icon of recently created content/assignment
       And Select "Edit" from actions dropdown
       Then Verify the popup message "Only basic details can be edited"
       When Update values in content fields "<contentTags>", "<duration>"
       And Click the button "UPDATE"
       Then Verify content is updated successfully "<contentTags>", "<duration>"

       Examples:
       |module        |submodule      |contentTags |duration|
       |Manage Courses|Content Library|Javascript  |01:00    |

  @regression
      Scenario Outline: Edit assignment (positive flow)
        Given Select "<module>", "<submodule>" from sidebar
        When Click Actions icon of recently created content/assignment
        And Select "Edit" from actions dropdown
        Then Verify the popup message "Only basic details can be edited"
        When Update values in assignment fields "<assignmentTag>", "<marks>"
        And Click the button "Update & Exit"
        Then Verify assignment is updated "<assignmentTag>", "<marks>"

        Examples:
          |module        |submodule         |assignmentTag|marks|
          |Manage Courses|Assignment Library|Javascript   |10   |

  @regression
        Scenario Outline:Deactivate status and verify
          Given Select "<module>", "<submodule>" from sidebar
          When Deactivate content/assignment status
          And Expand the dropdown containing status
          And Select "Inactive" from dropdown
          Then Verify deactivated content/assignment

          Examples:
          |module        |submodule         |
          |Manage Courses|Content Library   |
          |Manage Course |Assignment Library|


















       


