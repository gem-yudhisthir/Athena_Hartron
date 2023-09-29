Feature: Candidate module Hartron features

  Background:
    Given Navigate to page "login"
    And Expand the login via dropdown
    And Select "Email" from dropdown
    Then Login using "test@gmail.com" and "abc@123"
    And Change resolution

  @regression @Pass
  Scenario: Hartron_Candidate_VerifyLoggedInUserMail
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "Profile", "Change Password", "Logout"
    And Select change password from dropdown and verify the dialog box
    Then Verify the email of candidate "test@gmail.com"

  @regression @Pass
  Scenario Outline: Hartron_Candidate_VerifyExploreTestsBtnInProfile
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "<option1>", "<option2>", "<option3>"
    And Select "Profile" from dropdown
    And Click the button "Explore Tests"
    Then Verify user navigates to dashboard
    Examples:
      | option1 | option2         | option3 |
      | Profile | Change Password | Logout  |

  @regression @Pass
  Scenario Outline: Hartron_Candidate_ChangePasswordActions
    And Expand info dropdown from navbar
    Then Verify the options present in dropdown "<option1>", "<option2>", "<option3>"
    When Select "Change Password" from dropdown
    And Click the button "Change Password"
    Then Verify the error displayed in input fields "<error>" "<countMandatoryFields>"
    And Enter password "abc" and verify the required format "Must contain min 1 Alphabet(Lowercase), 1 Number & 1 Special character, Min Length should be 6, Max Length should be 10"
    And Enter a password in confirm password field "k", "Confirm Password"
    Then Verify the error displayed in input fields "password mismatch" "<countMandatoryFields1>"
    Then Verify user not able to edit email
    When Enter a password "abc@12311" in new password field
    And Enter a password in confirm password field "abc@12311", "Confirm Password"
    And Enter a password "abc@1231" in old password fields
    And Click the button "Change Password"

    Examples:
      | option1 | option2         | option3 | error                  | countMandatoryFields | countMandatoryFields1 |
      | Profile | Change Password | Logout  | This Field is required | 3                    | 1                     |

  @regression @Pass
  Scenario Outline: Hartron_Candidate_FetchStartEndDateOfTest
    Given Verify the default tab selected "<tab>"
    Then Get start and end date of test and verify current date is within range
    Examples:
      | tab          |
      | Active Tests |


  @regression @Pass
  Scenario: Hartron_Candidate_VerifyTestSubmittedButton
    When Switch to "Completed Tests"
    And Verify if Test Submitted button exists

  @regression @Pass
  Scenario Outline: Hartron_Candidate_ClickOnStartTestAndDon'tAttemptTest
    Then Verify the default tab selected "<tab>"
    And Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the No button and verify if test is started
    Examples:
      | tab          |
      | Active Tests |

  @regression @Pass
  Scenario Outline: Hartron_Candidate_ShuffleQuestionsTest_ClickOnSectionOpenIt
    When Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the Yes button
    And Click on the section ticket "<sectionName>"
    Then Verify there is no change in sections screen
    And Click the button "Attempt"
    Then Verify user navigates to questions screen of the selected section "Technical"
    Examples:
       | sectionName |
       | Technical   |

  @regression @Pass
  Scenario Outline: Hartron_Candidate_ShuffleQuestionsTest_NavigateBetweenExamSections
    When Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    And Click on the section ticket "<sectionName>"
    Then Verify user navigates to questions screen of the selected section "Logical"
    When Expand the dropdown containing sections
    And Select "Technical" from dropdown
    Then Verify user navigates to questions screen of the selected section "Technical"
    Examples:
    | sectionName |
    | Logical   |

  @regression @Pass
  Scenario: Hartron_Candidate_Save&NextBtnFunctionality
    When Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next
    And Click the button "Finish Test"
    Then Verify user is able to save answers


  @regression @Pass
  Scenario Outline: Hartron_Candidate_EnterSubjectiveAnswerSave&ClearGetWordLimit
    When Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click on the section ticket "<sectionName>"
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button "Save"
    And Click the button "Clear"
    And Get Word Limit value
    Examples:
    |sectionName|
    | Technical |


  @regression @Pass
  Scenario: Hartron_Candidate_ClearBtnFunctionality
    Then Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the Yes button
    Then Click the button "Attempt"
    Then Select or type an answer
    And Click the button "Clear"

  @regression @Pass
  Scenario: Hartron_Candidate_FetchQuestionCountAfterAttemptingParticularSection
    Then Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the Yes button
    Then Click the button "Attempt"
    Then Select or type all the questions of a section and save


  @regression @Pass
  Scenario: Hartron_Candidate_FinishTestWithoutSavingAnswers
    When Start test and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Click the Yes button
    Then Click the button "Attempt"
    And Click the button "Finish Test"
    Then Validate question count

  @regression @Pass
  Scenario: Hartron_Candidate_SaveQuestionWithoutAnswer
    When Start test and verify instructions video is displayed
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    And Click the button Save & Next
    Then Verify the popup message "to save the answer"

  @regression @Pass
  Scenario: Hartron_Candidate_FinishTestBackToDashboard
    When Start test and verify instructions video is displayed
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next
    And Click the button "Finish Test"
    And Click the "Yes" button after finishing test
    Then Verify user navigates to test summary screen
    When Click the button "Proceed"
    When Select Back To Dashboard
    Then Verify if user is on Dashboard


  @regression @Pass
  Scenario Outline: Hartron_Candidate_VerifyingStartTimeSumDurationWithEndTime
    Then Verify the default tab selected "<tab>"
    Then Get start and end time of test and verify duration
    Examples:
      | tab          |
      | Active Tests |


  @regression @Pass
  Scenario Outline: Hartron_Candidate_LogOut
    Given Verify the default tab selected "<tab>"
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "Profile", "Change Password", "Logout"
    And Select "Logout" from dropdown
    Then Verify if user is logged out

    Examples:
      | tab             |
      | Active Tests    |







































