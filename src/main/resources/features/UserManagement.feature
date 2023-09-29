Feature: User Management features

    Background:
     Given Navigate to page "login"
     And Login using "" and "abc@123"
   #   And Wait while screen loads


      @regression
    Scenario Outline: Register Role- Learner, Admin, Invigilator, Super Admin
      Given Select "<module>", "<submodule>" from sidebar
      When Click the button "<button>"
      Then Verify user is navigated to page "<page>"
      When Click the button "<button>"
      Then Verify the error displayed in input fields "<error>" "<countMandatoryFields>"
      When Select a role from dropdown "<role>"
      And Generate unique email
      And Enter password "abc" and verify the required format "Must contain min 1 Alphabet(Lowercase), 1 Number & 1 Special character, Min Length should be 6, Max Length should be 10"
      And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "", "9876543210", "10"
      And Click the button "<button>"
      And Switch to "<tab>"
      Then Verify "<role>" is registered "abcKk","def"
      When Click the button "<button>"
      And Select a role from dropdown "<role>"
      And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "", "9876543210", "10"
      And Click the button "<button>"
      Then Verify the popup message "<popupMsg>"

      Examples:
      |module         |button  |page           |error   |role         |tab      |popupMsg     |index|countMandatoryFields|
      |User Management|Register|User Management|required|Learner      |Learners  |already exist|3    |7                   |
      |User Management|Register|User Management|required|Admin        |Employees|already exist|1    |7                   |
      |User Management|Register|User Management|required|Invigilator  |Employees|already exist|1    |7                   |
      |User Management|Register|User Management|required|Super Admin  |Employees|already exist|1    |7                   |

  @regression
    Scenario Outline: Register Role- Candidate
      Given Select "<module>", "<submodule>" from sidebar
      When Click the button "<button>"
      Then Verify user is navigated to page "<page>"
      When Click the button "<button>"
      Then Verify the error displayed in input fields "<error>" "7"
      And Select a role from dropdown "<role>"
      And Generate unique email
      And Enter password "abc" and verify the required format "Must contain min 1 Alphabet(Lowercase), 1 Number & 1 Special character, Min Length should be 6, Max Length should be 10"
      And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "<inbuilt email>", "9876543210", "10"
      And Select campus from select campus dropdown
      And Select experience level from dropdown "Fresher"
      And Click the button "<button>"
      And Switch to tab "<tab>", "<index>"
      Then Verify "Candidate" is registered "abcKk","def"
      When Click the button "<button>"
      And Select a role from dropdown "<role>"
      And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "<inbuilt email>", "9876543210", "10"
      And Select campus from select campus dropdown
      And Select experience level from dropdown "Fresher"
      And Click the button "<button>"
      Then Verify the popup message "<popupMsg>"

      Examples:
      |module         |button  |page           |error   |role   |tab    |popupMsg     |index|
      |User Management|Register|User Management|required|Candidate|Candidates|already exist|2    |

  @regression
      Scenario Outline: Register user with multiple roles
        Given Select "<module>", "<submodule>" from sidebar
        When Click the button "<button>"
        Then Verify user is navigated to page "<page>"
        When Click the button "<button>"
        Then Verify the error displayed in input fields "<error>" "7"
        When Select a role from dropdown "<role1>"
        And Select a role from dropdown "<role2>"
        And Select a role from dropdown "<role3>"
        And Generate unique email
        And Enter password "abc" and verify the required format "Must contain min 1 Alphabet(Lowercase), 1 Number & 1 Special character, Min Length should be 6, Max Length should be 10"
        And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "", "9876543210", "10"
        And Click the button "<button>"
        And Switch to "Employees"
        Then Verify "<role1>" is registered "abcKk","def"
        Then Verify the role of registered user "<role1>","<role2>","<role3>"
        When Click the button "<button>"
        And Select a role from dropdown "<role1>"
        And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "", "9876543210", "10"
        And Click the button "<button>"
        Then Verify the popup message "<popupMsg>"

        Examples:
          |module         |button  |page           |error   |role1   |tab    |popupMsg     |index|role2|role3|
          |User Management|Register|User Management|required|Admin  |Employees|already exist|1  |Invigilator|Learner|

  @regression
        Scenario Outline: Validating roles of user from user's id
          Given Select "<module>", "<submodule>" from sidebar
          When Click the button "<button>"
          Then Verify user is navigated to page "<page>"
          When Click the button "<button>"
          Then Verify the error displayed in input fields "<error>" "<countMandatoryFields>"
          When Select a role from dropdown "<role1>"
          And Select a role from dropdown "<role2>"
          And Select a role from dropdown "<role3>"
          And Generate unique email
          And Enter password "abc" and verify the required format "Must contain min 1 Alphabet(Lowercase), 1 Number & 1 Special character, Min Length should be 6, Max Length should be 10"
          And Enter respective values in input fields "Abc@123", "Abc@123", "abcKk", "def", "", "9876543210", "10"
          And Click the button "<button>"
          And Switch to "Employees"
          Then Verify "<role1>" is registered "abcKk","def"
          Then Verify the role of registered user "<role1>","<role2>","<role3>"
          And Logout of portal
          When Login using "<inbuilt username>" and "Abc@123"
          And Select roles dropdown icon of navigation bar
          Then Verify the roles through user's id "<role1>", "<role2>", "<role3>"

          Examples:
            |module         |button  |page           |error   |role1   |role2|role3       |countMandatoryFields|
            |User Management|Register|User Management|required|Admin  |Invigilator|Learner|7                   |

  @regression
          Scenario Outline: Verify user is unable to edit role of a candidate
            Given Select "<module>", "<submodule>" from sidebar
            Then Switch to tab "<tab>", "<index>"
            When Select Actions icon of first candidate displayed
            And Select Edit Profile option
            Then Verify user is navigated to page "<string>"
            And Enable editing
            Then Verify user not able to edit role

            Examples:
            | module        | tab     | index | string    |
            |User Management|Candidate|2      |Update User|

  @regression
          Scenario Outline: Verify active/inactive user
            Given Select "<module>", "<submodule>" from sidebar
            When Switch to tab "<tab>", "<index>"
            And Select Actions icon of first record displayed in Employees
            And Select Edit Profile option
            Then Verify user is navigated to page "<string1>"
            And Enable editing
            Then Verify the status of user and click status button
            When Click the button "Update"
            And Click the button "Back"
            And Click the Yes button
            And Select Actions icon of first record displayed in Employees
            And Select Edit Profile option
            Then Verify user is navigated to page "<string1>"
            Then Verify the updated status

            Examples:
              | module        | tab     | index |string1|
              |User Management|Employees|1      |User Management / Update User|

  @regression
          Scenario Outline: Change role and validate
            Given Select "<module>", "<submodule>" from sidebar
            When Switch to tab "<tab>", "<index>"
            And Select Actions icon of first record displayed in Employees
            And Select Edit Profile option
            Then Verify user is navigated to page "<string1>"
            And Enable editing
            Then Verify the current role "<role1>", "<role2>", ""
            When Select a role from dropdown "<role1>"
            And Select a role from dropdown "<role2>"
            And Select a role from dropdown "<new role>"
            And Click the button "Update"
            Then Verify the role of registered user "<new role>","",""

            Examples:
              | module        | tab     | index |role1  |role2      |new role|string1|
              |User Management|Employees|1      |Learner|Super Admin|Admin   |User Management / Update User|

























