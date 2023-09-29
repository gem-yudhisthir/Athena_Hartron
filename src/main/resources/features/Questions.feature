Feature: Questions functionality

  Background:
    Given Navigate to page "login"
    And Login using "saloni02@gmail.com" and "abc@123"


    @regression
    Scenario Outline: Create a question
      Given Select "<module>", "<submodule>" from sidebar
      When Click the button "Add New"
      And Select dropdown values in question fields "<level>", "<type>", "<section>", "<difficulty>", "<skills>"
      And Enter marks "<marks>"
      And Click the button "Next"
      And Enter question description "<question1>"
      And Enter options and select a correct option
      And Click the button "Save & Add More"
      And Enter question description "<question2>"
      And Enter options and select a correct option
      And Click the button "Save & Exit"
      Then Verify the question is created "<question1>", "<question2>"

      Examples:
      |module |submodule|level|type                    |section|difficulty|skills|marks|question1|question2|
      |Tests  |Questions|Basic|Multiple choice question|Logical|Hard      |Java  |10   |ques-1?  |ques-2?  |
      |Tests  |Questions|Basic|Checkbox question       |Logical|Hard      |Java  |10   |ques-1!  |ques-2!  |

#    Scenario Outline:Create subjective question
#      Given Select "<module>", "<submodule>" from sidebar
#      When Click the button "Add New"
#      And Select dropdown values in question fields "<level>", "<type>", "<section>", "<difficulty>", "<skills>"
#      And Enter marks "<marks>"
#      And Click the button "Next"
#      And Enter question description "<question1>"
#      And Expand the dropdown "Has Word Limit?"
