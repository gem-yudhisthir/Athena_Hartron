Feature: Candidate module Hartron features

  Background:
    Given Navigate to page "login"
    And Expand the login via dropdown
    And Select "Email" from dropdown
    Then Login using "automate@gmail.com" and "abc@123"
    And Change resolution


  @regression
  Scenario: AthenaHartron_Candidate_Login_Action
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "Profile", "Change Password", "Logout"
    And Select change password from dropdown and verify the dialog box
    Then Verify the email of candidate "automate@gmail.com"

  @regression
  Scenario Outline: AthenaHartron_Candidate_ExploreTestsInProfile
    When Expand info dropdown from navbar
    Then Verify the options present in dropdown "<option1>", "<option2>", "<option3>"
    And Select "Profile" from dropdown
    And Click the button "Explore Tests"
    Then Verify user navigates to dashboard
    Examples:
      | option1 | option2         | option3 |
      | Profile | Change Password | Logout  |

  @regression
  Scenario Outline: Validate password errors
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
    Then Verify the popup message "Password updated successfully!"

    Examples:
      | option1 | option2         | option3 | error                  | countMandatoryFields | countMandatoryFields1 |
      | Profile | Change Password | Logout  | This Field is required | 3                    | 1                     |

  @regression
  Scenario Outline: Verify current date is within test date range
    Then Verify the default tab selected "<tab>"
    Then Get start and end date of test and verify current date is within range
    Examples:
      | tab          |
      | Active Tests |


  @regression
  Scenario: View test report
    When Switch to "Completed Tests"
    And Click on View Report
    Then Verify the report screen

  @regression
  Scenario Outline: Verify the test that is started
    Then Verify the default tab selected "<tab>"
    And Start test "<testName>" and verify instructions video is displayed
    Then Verify user is navigated to desired test "<testName>"

    Examples:
      | tab          | activeTests | testName     |
      | Active Tests | 3           | NewCheckEdit |

  @regression
  Scenario Outline: Verify selected section gets opened
    When Start test "<testName>" and verify instructions video is displayed
    Then Verify user is navigated to desired test "<testName>"
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    And Verify dialog box appears
    Then Click the Yes button
    And Click on the section ticket "<sectionName>"
    Then Verify there is no change in sections screen
    And Click the button "Attempt"
    Then Verify user navigates to questions screen of the selected section "Technical"

    Examples:
      | testName     | sectionName |
      | NewCheckEdit | Technical   |

  @regression
  Scenario Outline: Navigation between the sections
    When Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Click on the section ticket "<sectionName>"
    Then Verify user navigates to questions screen of the selected section "Logical"
    When Expand the dropdown containing sections
    And Select "Technical" from dropdown
    Then Verify user navigates to questions screen of the selected section "Technical"
    Examples:
      | testName     | sectionName |
      | NewCheckEdit | Logical   |

  @regression
  Scenario Outline: Verify user is able to save answers
    When Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next
    And Click the button "Finish Test"
    Then Verify user is able to save answers

    Examples:
      | testName     | questionStatus |
      | NewCheckEdit | submitted      |

  @regression
  Scenario Outline: Verify clear functionality
    Then Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    And Verify dialog box appears
    Then Click the Yes button
    Then Click the button "Attempt"
    Then Select or type an answer
    And Click the button "Clear"
    Then Verify the answer got cleared

    Examples:
      | testName     |
      | NewCheckEdit |

  @regression
  Scenario Outline: Verify the question count after attempting a particular section
    Then Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    Then Click the button "NEXT"
    And Verify dialog box appears
    Then Click the Yes button
    Then Click the button "Attempt"
    Then Select or type all the questions of a section and save
    Then Validate questions count "", "", ""

    Examples:
      | testName     | total | attempted | unattempted |
      | NewCheckEdit | 2     | 2         | 0           |

  @regression
  Scenario Outline: Verify entire test flow
    When Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    Then Click the Yes button
    Then Click the button "Attempt"
    Then Select or type all the questions of entire test
    And Click the button "Finish Test"
    Then Validate question count

    Examples:
      | testName             | total | attempted | unattempted |
      | testMultipleSections | 5     | 5         | 0           |

  @regression
  Scenario Outline: Verify clear functionality after saving an answer
    When Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next
    And Click the left arrow button
    And Click the button "Clear"
    Then Verify the answer got cleared

    Examples:
      | testName     |
      | NewCheckEdit |

  @regression
  Scenario Outline: Refresh while attempting test
    When Start test "<testName>" and verify instructions video is displayed
    Then Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Click on the section ticket "<sectionName>"
    And Select or type an answer
    And Click the button Save & Next
    And Refresh the page, cancel alert and verify user is on same page
    And Refresh the page, accept alert and verify user navigates to instructions screen

    Examples:
      | testName | sectionName | questionNo |
      | mcqTest  | Logical     | 2          |

  @regression
  Scenario Outline: Save a question without answering it
    When Start test "<testName>" and verify instructions video is displayed
    And Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Click the button Save & Next
    Then Verify the popup message "to save the answer"
    Examples:
      | testName     |
      | NewCheckEdit |

  @regression
  Scenario Outline: Finish a test and check in completed tests tab
    When Start test "<testName>" and verify instructions video is displayed
    And Check the instructions checkbox
    And Click the button "NEXT"
    Then Verify dialog box appears
    When Click the Yes button
    And Click the button "Attempt"
    And Select or type an answer
    And Click the button Save & Next
    And Click the button "Finish Test"
    And Click the "Yes" button after finishing test
    Then Verify user navigates to test summary screen
    When Click the button "Proceed"
    When Select Back To Dashboard
    And Switch to "Completed Tests"
    Then Verify "<testName>" is present in completed tests

    Examples:
      | testName     |
      | NewCheckEdit |

    #Additional Testcases

  @regression
  Scenario Outline: Hartron_Candidate_Verify timings match with duration
    Then Verify the default tab selected "<tab>"
    Then Get start and end time of test and verify duration
    Examples:
      | tab          |
      | Active Tests |

  Scenario Outline: Hartron_Candidate_Log Out
    Then Navigate to Completed Tests Tab
    Then Verify the default tab selected "<tab>"
    Then Get start and end time of test and verify duration
    Examples:
      | tab             |
      | Completed Tests |
