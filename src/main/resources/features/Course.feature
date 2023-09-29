Feature:Course module features

  Background:Check login to candidate module
    Given Navigate to page "login"
    Then Login using "rahul23@gmail.com" and "abc@123"

  Scenario Outline: Create Course Verify Owner
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Course"
    Then Verify the Owner of the Created Course

    Examples:
      | module        |submodule     |
      | Manage Courses|Course Library|

  Scenario Outline: Create Course Verify Course Info Tree
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Course"
    Then Verify course info tree for assignment and test checkbox

    Examples:
      | module        |submodule     |
      | Manage Courses|Course Library|

  Scenario Outline: Create Course verify Add Content
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Course"
    And Enter respective values in course fields "<courseType>", "<duration>", "<courseTag>", "<fileLocation>", "<category>"
    And Enter course description "<description>"
    And Click the button "Add Content"
    And Validate Filter functionality "<contentName>"
    And Validate Add to Course "<contentMessage>"
    Examples:
      | module        |submodule     |courseType|duration|courseTag|category|fileLocation|description|contentName|contentMessage|
      | Manage Courses|Course Library|Public    |  30 |  Java   | Logical| C:\Users\rahul.adhikari\Pictures\testImage.jpg |abc|content -01|Content successfully added. Add more!|

  Scenario Outline: Create Course verify Add Assignment
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Course"
    And Enter respective values in course fields "<courseType>", "<duration>", "<courseTag>", "<fileLocation>", "<category>"
    And Enter course description "<description>"
    And Click the button "Add Content"
    And Validate Add to Course "<contentMessage>"
    And Validate Filter functionality "<assignmentName>"
    Then Validate Add to Course "<assignmentMessage>"
    Examples:
      | module        |submodule     |courseType|duration|courseTag|category|fileLocation|description|assignmentName|contentMessage|assignmentMessage|
      | Manage Courses|Course Library|Public    |  30 |  Java   | Logical| C:\Users\rahul.adhikari\Pictures\testImage.jpg |abc|new assignment-01 |Content successfully added. Add more!|Assignment successfully added. Add more!|

  Scenario Outline: Edit and verify the course
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Course"
    And Enter respective values in course fields "<courseType>", "<duration>", "<courseTag>", "<fileLocation>", "<category>"
    And Enter course description "<description>"
    And Click the button "Add Content"
    And Validate Add to Course "<contentMessage>"
    And Validate Filter functionality "<assignmentName>"
    And Validate Add to Course "<assignmentMessage>"
    Then Edit the Created Course and Verify

    Examples:
      | module        |submodule     |courseType|duration|courseTag|category|fileLocation|description|assignmentName|contentMessage|assignmentMessage|
      | Manage Courses|Course Library|Public    |  30 |  Java   | Logical| C:\Users\rahul.adhikari\Pictures\testImage.jpg |abc|new assignment-01 |Content successfully added. Add more!|Assignment successfully added. Add more!|

  Scenario Outline: Create Course verify Course Summary
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button until it appear "Create Course"
    And Enter respective values in course fields "<courseType>", "<duration>", "<courseTag>", "<fileLocation>", "<category>"
    And Enter course description "<description>"
    And Click the button until it appear "Add Content"
    And Validate Add to Course "<contentMessage>"
    And Validate Filter functionality "<assignmentName>"
    And Validate Add to Course "<assignmentMessage>"
    Then Validate Course Summary Screen
    Examples:
      | module        |submodule     |courseType|duration|courseTag|category|fileLocation|description|assignmentName|contentMessage|assignmentMessage|
      | Manage Courses|Course Library|Public    |  30 |  Java   | Logical| C:\Users\rahul.adhikari\Pictures\testImage.jpg |abc|new assignment-01 |Content successfully added. Add more!|Assignment successfully added. Add more!|




  Scenario Outline: Assign Created Course and verify the result once the user complete the course
    Given Select "<module>", "<submodule>" from sidebar
    When A Learner is assign to a course
    And Change the user's role "<Role>"
    And Filter the course and complete it
    And Select "<module>", "<submodule>" from sidebar
    Then Verify the Learner Report "<Learner>", "<Email>", "<Percentage>", "<Status>"

    Examples:
      |Role   |  module      |submodule     |Learner|Email|Percentage|Status|
      |Learner|Manage Courses|Course Library|rahulll|rahul23@gmail.com|100%|Completed|

  Scenario Outline: Reattempt already completed Course
    Given Select "<module>", "<submodule>" from sidebar
    When Reattempt the test to the user
    And Change the user's role "<Role>"
    And Filter the course and complete it
    And Select "<module>", "<submodule>" from sidebar
    Then Verify the Learner Report "<Learner>", "<Email>", "<Percentage>", "<Status>"

    Examples:
      |Role   |  module      |submodule     |Learner|Email|Percentage|Status|
      |Learner|Manage Courses|Course Library|rahulll|rahul23@gmail.com|100%|Completed|