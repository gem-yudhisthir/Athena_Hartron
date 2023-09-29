Feature: Learner module features

  Background:Check login to Learner module
    Given Navigate to page "login"
    Then Login using "rahul23@gmail.com" and "abc@123"

  @regression012
  Scenario Outline: Course Resume Validation
    When Expand user dropdown from navbar
    Then Verify the options present in dropdown and select it "<option1>"
    And Verify View Course Button and click it
    And Validate Resume Course after starting the course

    Examples:
      |option1|
      |Learner|


  @regression012
  Scenario Outline: Course completion and Download
    When Expand user dropdown from navbar
    Then Verify the options present in dropdown and select it "<option1>"
    And Complete the Course and Download the certificate

    Examples:
      |option1|
      |Learner|


  @regression012
  Scenario Outline: Validate Ongoing and Completed Course Count
    When Expand user dropdown from navbar
    Then Verify the options present in dropdown and select it "<option1>"
    And Validate the count of Ongoing and Completed Course
    And Switch to Completed Tab and validate it functionality
    And Validate Course Summary

    Examples:
      |option1|
      |Learner|


  @regression012
  Scenario Outline: Course catalog validation
    When Expand user dropdown from navbar
    Then Verify the options present in dropdown and select it "<option1>"
    And validate test and assignment count matches
    And Enroll in course and verify
    Then Apply Filter and validate the result for Course

    Examples:
      |option1|
      |Learner|