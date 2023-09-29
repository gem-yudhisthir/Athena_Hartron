Feature:Tests Module features

  Background:Check login to candidate module
    Given Navigate to page "login"
    Then Login using "rahul23@gmail.com" and "abc@123"

  Scenario Outline: Create Test Placement Drive
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    Then Assign the test to Learner


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|
      | Tests         |Test Control  |Java   |0030    |DELL, DELL|Beginner|13       |14     |abc        |Logical|5         |


  Scenario Outline: Create Test Placement Drive->verify show score after submission
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    And Assign the test to Learner
    And Switch the User "<Username>", "<Password>"
    Then Start with test


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|Username|Password|
      | Tests         |Test Control  |Pythonhhgf   |0030    |DELL, DELL|Beginner|14       |15     |abc        |Logical|5   |rahul22@gmail.com|abc@123|


  Scenario Outline: Create Test Placement Drive->verify Test Reattempt
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Check the Required Checkbox Filter "<checkboxOption>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    And Assign the test to Learner
    And Switch the User "<Username>", "<Password>"
    Then Start with test
    Then Validate Test Reattempt


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|checkboxOption|Username|Password|
      | Tests         |Test Control  |Pytnlkiu   |0030    |DELL, DELL|Beginner|14       |15     |abc        |Logical|5         |2       |rahul22@gmail.com|abc@123|



  Scenario Outline: Create Test Placement Drive->Attempt->Validate Candidate Report
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    And Assign the test to Learner
    And Switch the User "<Username1>", "<Password1>"
    Then Start with test
    And Switch the User "<Username>", "<Password>"
    Then Validate Candidate Report


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|Username|Password|Username1|Password1|
      | Tests         |Test Control  |Dot tlllhhll  |0030    |DELL, DELL|Beginner|18       |19     |abc        |Logical|5|rahul23@gmail.com|abc@123|rahul22@gmail.com|abc@123|


  Scenario Outline: Create Test Placement Drive->Attempt->Validate Test Summary Report
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    And Assign the test to Learner
    And Switch the User "<Username1>", "<Password1>"
    Then Start with test
    And Switch the User "<Username>", "<Password>"
    Then Validate Test Summary Report "<Campus>"


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|Username|Password|Username1|Password1|
      | Tests         |Test Control  |Dot Dot Net  |0030    |DELL, DELL|Beginner|15       |16     |abc        |Logical|5   |rahul23@gmail.com|abc@123|rahul22@gmail.com|abc@123|


  Scenario Outline: Create Test Placement Drive->Attempt->Validate Copy Test
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    Then Create and Validate Copy of Test "<EndDate>"


    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|
      | Tests         |Test Control  |Dot y Dot  |0030    |DELL, DELL|Beginner|18       |19    |abc        |Logical|5         |

  Scenario Outline: Create Test Placement Drive->Attempt->Validate Edit Test
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    Then Edit and Validate Created Test



    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|
      | Tests         |Test Control  |Dot ytaf Dot  |0030    |DELL, DELL|Beginner|18       |19    |abc        |Logical|5         |


  Scenario Outline: Create Test Placement Drive->Attempt->Validate Candidate Assigned
    Given Select "<module>", "<submodule>" from sidebar
    When Click the button "Create Test"
    And Add Test Info "<TestTag>", "<Duration>", "<Campus>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created
    Then Assign Candidate and Verify it

    Examples:
      | module        |submodule     |TestTag|Duration|Campus    |Level   |StartDate|EndDate|Description|Section|Percentage|
      | Tests         |Test Control  |dot.net  |0030    |DELL, DELL|Beginner|18       |19    |abc        |Logical|5         |

  Scenario Outline: Create Internal Tests
    Given Select "<module>", "<submodule>" from sidebar
    When Switch to "<TestType>"
    And Click the Internal Test button until it appear "Create Test"
    And check the checkbox "<checkboxLabel>"
    And Add Test Info for Internal Test  "<TestTag>", "<Duration>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    Then Validate Test is Created for Internal
#    Then Assign the test to Learner


    Examples:
      | module        |submodule     |TestTag|Duration|Level   |StartDate|EndDate|Description|Section|Percentage|TestType|checkboxLabel|
      | Tests         |Test Control  |Mongodb123  |0030  |Beginner|20      |21     |abc        |Logical|5         |Internal Tests|Internal Test|


  Scenario Outline: Create Internal Test->verify show score after submission
    Given Select "<module>", "<submodule>" from sidebar
    When Switch to "<TestType>"
    And Click the Internal Test button until it appear "Create Test"
    And check the checkbox "<checkboxLabel>"
    And Add Test Info for Internal Test  "<TestTag>", "<Duration>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created for Internal
    And Assign the Internal test to Learner
    And Switch the User "<Username>", "<Password>"
    And Select "<learnerModule>" from sidebar
    Then Start with test


    Examples:
      | module        |submodule     |TestTag|Duration|Level   |StartDate|EndDate|Description|Section|Percentage|Username|Password|checkboxLabel|TestType|learnerModule|
      | Tests         |Test Control  |Pojjnxc   |0030    |Beginner|20       |21     |abc        |Logical|5   |rahul44@gmail.com|abc@123|Internal Test|Internal Tests|Tests|


  Scenario Outline: Create Internal Test->verify Test Reattempt
    Given Select "<module>", "<submodule>" from sidebar
    When Switch to "<TestType>"
    And Click the Internal Test button until it appear "Create Test"
    And check the checkbox "<checkboxLabel>"
    And Add Test Info for Internal Test  "<TestTag>", "<Duration>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Check the Required Checkbox Filter "<checkboxOption>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created for Internal
    And Assign the Internal test to Learner
    And Switch the User "<Username>", "<Password>"
    And Select "<learnerModule>" from sidebar
    Then Start with test
    Then Validate Test Reattempt


    Examples:
      | module        |submodule     |TestTag|Duration|Level   |StartDate|EndDate|Description|Section|Percentage|checkboxOption|Username|Password|learnerModule|TestType|checkboxLabel|
      | Tests         |Test Control  |Spring Boot|0030    |Beginner|20       |21     |abc        |Logical|5         |2       |rahul44@gmail.com|abc@123|Tests|Internal Tests|Internal Test|


  Scenario Outline: Create Internal Test->Attempt->Validate Candidate Report
    Given Select "<module>", "<submodule>" from sidebar
    When Switch to "<TestType>"
    And Click the Internal Test button until it appear "Create Test"
    And check the checkbox "<checkboxLabel>"
    And Add Test Info for Internal Test  "<TestTag>", "<Duration>", "<Level>", "<StartDate>", "<EndDate>"
    And Enter Test Description "<Description>"
    And Click the button "Next"
    And Add Section "<Section>", "<Percentage>", "<Duration>"
    And Click the button "Add"
    And Add Question to the section
    And Validate Test is Created for Internal
    And Assign the Internal test to Learner
    And Switch the User "<Username1>", "<Password1>"
    And Select "<learnerModule>" from sidebar
    Then Start with test
    And Switch the User "<Username>", "<Password>"
    Then Validate Candidate Report


    Examples:
      | module        |submodule     |TestTag|Duration|Level   |StartDate|EndDate|Description|Section|Percentage|Username|Password|Username1|Password1|learnerModule|TestType|checkboxLabel|checkboxOption|
      | Tests         |Test Control  |Spring bt mv |0030    |Beginner|21       |22     |abc        |Logical|5|rahul23@gmail.com|abc@123|rahul44@gmail.com|abc@123|Tests|Internal Tests|Internal Test|2     |