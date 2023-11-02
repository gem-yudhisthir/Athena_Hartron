Feature: Candidate module Hartron features

  Background:
    And Expand the login via dropdown
    Then Login using "test@gmail.com" and "abc@123"
    And Change resolution

  @script_fix
  Scenario: Hartron_Candidate_VerifyLoggedInUserMail
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "Profile", "Change Password", "Logout"
    And Select change password from dropdown and verify the dialog box
    Then Verify the email of candidate "test@gmail.com"

  @script_fix
  Scenario Outline: Hartron_Candidate_VerifyExploreTestsBtnInProfile
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "<option1>", "<option2>", "<option3>"
    And Select "Profile" from dropdown
    And Click the button "Explore Tests"
    Then Verify user navigates to dashboard
    Examples:
      | option1 | option2         | option3 |
      | Profile | Change Password | Logout  |

  @script_fix
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

  @script_fix
  Scenario Outline: Hartron_Candidate_FetchStartEndDateOfTest
    Given Verify the default tab selected "<tab>"
    Then Get start and end date of test and verify current date is within range
    Examples:
      | tab          |
      | Active Tests |


  Scenario: Hartron_Candidate_VerifyTestSubmittedButtonForCompletedTest
    When Switch to "Completed Tests"
    And Verify if Test Submitted button exists


  Scenario Outline: Hartron_Candidate_ClickOnStartTestAndDon'tAttemptTest
    Then Verify the default tab selected "<tab>"
    And Start test
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the No button and verify if test is started
    Examples:
      | tab          |
      | Active Tests |


  Scenario Outline: Hartron_Candidate_ShuffleQuestionsTest_ClickOnSectionOpenIt
    When Start test
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


  Scenario Outline: Hartron_Candidate_ShuffleQuestionsTest_NavigateBetweenExamSections
    When Start test
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click on the section ticket "<sectionName>"
    Then Verify user navigates to questions screen of the selected section "Section C"
    When Expand the dropdown containing sections
    And Select "Technical" from dropdown
    Then Verify user navigates to questions screen of the selected section "Technical"
    Examples:
      | sectionName |
      | Section C   |


  Scenario: Hartron_Candidate_Save&NextBtnFunctionality
    When Start test
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next

  Scenario: Hartron_Candidate_ClearBtnFunctionality
    Then Start test
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the Yes button
    And Click on Subjective section Attempt
    Then Select or type an answer
    And Click the button "Clear"

  Scenario: Hartron_Candidate_EnterSubjectiveAnswerSave&GetWordLimit
    When Start test
    Then Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click on Subjective section Attempt
    And Select or type an answer
    And Click the button "Save"
    And Get Word Limit value

  Scenario: Hartron_Candidate_FetchQuestionCountAfterAttemptingParticularSection
    Then Start test
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    Then Click the Yes button
    And Click on Subjective section Attempt
    Then Select or type all the questions of a section and save

  Scenario: Hartron_Candidate_FinishTestWithoutSavingAnswers
    When Start test
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Click the Yes button
    And Click on Subjective section Attempt
    And Click the button "Finish Test"

  Scenario: Hartron_Candidate_SaveQuestionWithoutAnswer
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click on Subjective section Attempt
    And Click the button Save & Next
    Then Verify the popup message "to save the answer"

  @AutomatedByYudhishthir
  Scenario Outline: Hartron_Candidate_VerifyingStartTimeSumDurationWithEndTime
    Then Verify the default tab selected "<tab>"
    Then Get start and end time of test and verify duration
    Examples:
      | tab          |
      | Active Tests |


  Scenario Outline: Hartron_Candidate_LogOut
    Given Verify the default tab selected "<tab>"
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "Profile", "Change Password", "Logout"
    And Select "Logout" from dropdown
    Then Verify if user is logged out
    Examples:
      | tab             |
      | Active Tests    |

  Scenario Outline:Hartron_Candidate_ClickOnHartronLogoVerifyIfUserInHomePage
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    Then Click on Hartron Logo from "<sections>" page verify if user is in home page
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    Then Click on Hartron Logo from "<exams>" page verify if user is in home page
    Examples:
      |sections |    exams|
      | section |   exam  |

  Scenario Outline: Hartron_Candidate_VerifyCourseEnrollmentValueInHeaderAndProfileMatches
    Given Verify the default tab selected "<tab>"
    Then Fetch Enrollment No and Course values
    When Expand info dropdown from navbar
    And Select "Profile" from dropdown
    Then Verify if Course and Enrollment value matches with Header and in Profile
    Examples:
      | tab             |
      | Active Tests    |

  Scenario:Hartron_Candidate_ClickOnCtrlButtonDuringExamVerifyPopup
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    Then Perform Ctrl Keyboard Action and verify popup

  Scenario:Hartron_Candidate_ContinueErrPopupVerifyUserOnTest
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    And Click the button "Attempt"
    Then Perform Ctrl Keyboard Action and verify popup
    And Click on Continue Verify if User is back to test

  Scenario Outline:Hartron_Candidate_VerifyActive&CompletedTestsButtonsOnDashboard
    Given Verify the default tab selected "<tab>"
    When Switch to "Completed Tests"
    Examples:
      | tab          |
      | Active Tests |

  Scenario:Hartron_Candidate_VerifyDeadlineMatchesOnDashboardAndInstructions
    When Get test Deadline Before Test
    When Start test
    Then verify if deadline matches on dashboard and instructions screen

  Scenario Outline:Hartron_Candidate_SectionOrderAndCountInstructionsAndSectionsScreen
    When Get test section details "<Section 1>","<Section 2>","<Section 3>","<Section 4>","<Section 5>" and "<Section 6>" on instruction screen
    When Start test
    And Check the instructions checkbox
    And Click the button "NEXT"
    When Click the Yes button
    Then Get section details from section screen
    Examples:
      |Section 1|Section 2|Section 3|Section 4|Section 5|Section 6|
      |Section B|Logical|Section A| Technical|Section C|Programming language|

  @regression @Pass @LAST
  Scenario: Hartron_Candidate_FinishTestBackToDashboard
    When Start test
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

  @LAST_1
  Scenario Outline: Hartron_Candidate_VerifySubmittedTestMovedToCompletedTestsTab
    Given Verify the default tab selected "<tab>"
    When Switch to "Completed Tests"
    Then Verify if submitted test is moved to Completed tests tab
    Examples:
      | tab          |
      | Active Tests |
