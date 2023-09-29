package com.gemini.athena.stepdefinitions;


import com.gemini.athena.locators.Course_Locators;
import com.gemini.athena.locators.LearnerModule_Locators;
import com.gemini.athena.locators.MyLocators;
import com.gemini.athena.locators.Tests_TestControl_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tests_TestControl {
    Logger logger = LoggerFactory.getLogger(LearnerModule.class);
    String testName = " ";

    @And("^Add Test Info \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void addTestInfo(String testTag, String duration, String campus, String level, String startDate, String endDate) {
        try {
            int c = 2;
            int c1 = 1;
            List<WebElement> inputFields = new ArrayList<>();
            if (DriverAction.isExist(Tests_TestControl_Locators.testInputFields, 120)) {
                inputFields = DriverAction.getElements(Tests_TestControl_Locators.testInputFields);
            } else {
                inputFields = DriverAction.getElements(Tests_TestControl_Locators.testInputFieldsInternal);
            }
            testName = RandomStringUtils.randomAlphanumeric(10);
            String inputValues[] = {testName, testTag, duration, campus, level, startDate, endDate};
            for (int i = 1; i <= 7; i++) {
                String dropdown = inputFields.get(i).getAttribute("aria-haspopup");
                String calendar = inputFields.get(i).getAttribute("id");
//           String upload = inputFields.get(i).getAttribute("type");
                //dropdown
                if (dropdown != null && dropdown.equals("listbox")) {

                    DriverAction.click(By.xpath(Course_Locators.dropdownIcon.replace("itr", String.valueOf(c))));
                    DriverAction.click(By.xpath(Course_Locators.option.replace("input", inputValues[i - 1])));
                    c++;
                }
                //calendar
                if (calendar != null && (calendar.equals("calendar1") || calendar.equals("calendar2"))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.calendar.replace("itr", String.valueOf(c1))));
                    DriverAction.waitSec(3);
                    if (c1 == 1) {
//                   DriverAction.click(By.xpath("//span[text()='12']"));
                        DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date", startDate)));
                    } else if (c1 == 2) {
//                   DriverAction.click(By.xpath("//span[text()='13']"));
                        DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date", endDate)));
                    }
                    c1++;
                }
                //textbox
                else {
                    DriverAction.waitSec(3);
                    DriverAction.typeText(inputFields.get(i), inputValues[i - 1]);
                }
            }
            DriverAction.scrollToBottom();
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @And("^Enter Test Description \"([^\"]*)\"$")
    public void courseDescription(String description) {
        try {
            DriverAction.scrollToBottom();
            DriverAction.typeText(Course_Locators.courseDescription, description);

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Add Section \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void addSection(String section, String percentage, String duration) {
        try {
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.dropdown)) {
                DriverAction.click(Tests_TestControl_Locators.dropdown);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.option.replace("section", section)))) ;
                {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.option.replace("section", section)));
                }
                if (DriverAction.isDisplayed(Tests_TestControl_Locators.percentageInput)) {
                    DriverAction.typeText(Tests_TestControl_Locators.percentageInput, percentage);
                }
                if (DriverAction.isDisplayed(Tests_TestControl_Locators.timeInput)) {
                    DriverAction.typeText(Tests_TestControl_Locators.timeInput, duration);
                }
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @And("^Add Question to the section$")
    public void addQuestionSection() {
        try {
            DriverAction.scrollToBottom();

            //click on Add Question for the following test
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.addQuestion)) {
                DriverAction.click(Tests_TestControl_Locators.addQuestion);
            }
            DriverAction.scrollToBottom();
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.importRandomBtn)) {
                DriverAction.click(Tests_TestControl_Locators.importRandomBtn);
            }
            DriverAction.waitSec(3);
            //filling the Question Details
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.questionTypeDropdown)) {
                DriverAction.click(Tests_TestControl_Locators.questionTypeDropdown);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.options.replace("input", "Multiple choice question")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.options.replace("input", "Multiple choice question")));
                }
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.noOfQuestionInput)) {
                DriverAction.typeText(Tests_TestControl_Locators.noOfQuestionInput, "2");
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.difficultyDropdown)) {
                DriverAction.click(Tests_TestControl_Locators.difficultyDropdown);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.options.replace("input", "Hard")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.options.replace("input", "Hard")));
                }
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.levelDropdown)) {
                DriverAction.click(Tests_TestControl_Locators.levelDropdown);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.options.replace("input", "Basic")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.options.replace("input", "Basic")));
                }
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.submitButton)) {
                DriverAction.click(Tests_TestControl_Locators.submitButton);
            }
            DriverAction.scrollToBottom();
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.saveButton)) {
                DriverAction.click(Tests_TestControl_Locators.saveButton);
            }
            DriverAction.scrollToBottom();
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.continueButton)) {
                DriverAction.click(Tests_TestControl_Locators.continueButton);
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Validate Test is Created$")
    public void validateTestCreated() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.createdTestText)) {
                String fetchedTestName = DriverAction.getElementText(Tests_TestControl_Locators.createdTestText);
                System.out.println(fetchedTestName);
                if (testName.equals(fetchedTestName)) {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is Created Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is not Created Successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                }

            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Validate Test is Created for Internal$")
    public void validateTestCreatedInternal() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInputInternal, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInputInternal, testName);
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.createdTestTextInternal)) {
                String fetchedTestName = DriverAction.getElementText(Tests_TestControl_Locators.createdTestTextInternal);
                System.out.println(fetchedTestName);
                if (testName.equals(fetchedTestName)) {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is Created Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is not Created Successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                }

            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Assign the test to Learner$")
    public void assignLearner() {
        try {
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.threeDotIcon)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")));
                }
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.filterInput)) {
                DriverAction.typeText(Tests_TestControl_Locators.filterInput, "rahul22@gmail.com");
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(Course_Locators.addIcon)) {
                    DriverAction.click(Course_Locators.addIcon, "Clicked on add Content Icon", "Successfully clicked on Add Content Icon");
                }
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Start with test$")
    public void startTest() {
        try {
            //logout from the account
//            if (DriverAction.isDisplayed(Course_Locators.navbarDropdown)) {
//                DriverAction.click(Course_Locators.navbarDropdown, "Click on the Dropdown button", "successfully clicked Dropdown button.");
//                if (DriverAction.isDisplayed(Tests_TestControl_Locators.logout)) {
//                    DriverAction.click(Tests_TestControl_Locators.logout, "Click on Logout Option", "successfully select Logout option.");
//                }
//            }
//            //login as candidate
//            if (DriverAction.isDisplayed(MyLocators.usernameField)) {
//                DriverAction.typeText(MyLocators.usernameField, "rahul22@gmail.com");
//            }
//            if (DriverAction.isDisplayed(MyLocators.passwordField)) {
//                DriverAction.typeText(MyLocators.passwordField, "abc@123");
//            }
//            DriverAction.waitUntilElementClickable(MyLocators.loginBtn, 90);
//            if (DriverAction.isDisplayed(MyLocators.loginBtn)) {
//                DriverAction.click(MyLocators.loginBtn, "Clicked on Login Button", "Successfully Clicked on Login Button");
//            }
//
//            //wait while the page loads.
//            if (DriverAction.isExist(MyLocators.spinner)) ;
//            DriverAction.waitUntilElementDisappear(MyLocators.spinner, 20);

            //verify dashboard is displayed on login
            if (DriverAction.isExist(MyLocators.dashboard)) {
                GemTestReporter.addTestStep("Verify dashboard is displayed", "Successfully displayed the dashboard.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            List<WebElement> activeTestHeadingList = DriverAction.getElements(Tests_TestControl_Locators.activeTestHeadingList);
            for (int i = 0; i < activeTestHeadingList.size(); i++) {
                String heading = DriverAction.getElementText(activeTestHeadingList.get(i));
                System.out.println(heading);
                if (heading.equals(testName)) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.startBtn.replace("itr", String.valueOf(i + 1))));
                }
            }
//        if(DriverAction.isDisplayed(Tests_TestControl_Locators.startTestBtn))
//        {
//            DriverAction.click(Tests_TestControl_Locators.startTestBtn,"Clicked on Start Test Button","Successfully Clicked on Start Test Button");
//
//        }

            //test
            //click the next button to forward the vedio.
            DriverAction.waitUntilElementClickable(By.xpath(MyLocators.nextBtn.replace("input", "NEXT")), 90);
            DriverAction.click(By.xpath(MyLocators.nextBtn.replace("input", "NEXT")), "Click the NEXT button displayed in video", "Successfully clicked the NEXT button displayed in video.");
            //check the instruction checkbox
            DriverAction.click(MyLocators.instructionsCheckbox);
            GemTestReporter.addTestStep("Check the instructions checkbox", "Successfully checked the instructions checkbox.", STATUS.PASS);
            DriverAction.click(By.xpath(MyLocators.button.replace("input", "NEXT")));
            //verify dailogue box appear
            if (DriverAction.isExist(MyLocators.startTestDialog)) {
                GemTestReporter.addTestStep("Verify confirmation dialog box appears", "Successfully verified the confirmations dialog box.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify confirmation dialog box appears", "Could not verify confirmation dialog box.", STATUS.FAIL);
            }
            DriverAction.click(MyLocators.yesBtn, "Click the yes button", "Successfully clicked Yes button.");
            //click attempt button
            DriverAction.click(By.xpath(MyLocators.button.replace("input", "Attempt")));
            //expand section
            DriverAction.click(MyLocators.sectionsDropdown, "Click the sections dropdown", "Sections dropdown is expanded successfully.");
            List<WebElement> sections = DriverAction.getElements(MyLocators.totalSections);
            int numOptions = sections.size();
            for (int k = 0; k < numOptions; k++) {
                if (k != 0) {
                    DriverAction.click(MyLocators.sectionsDropdown, "Click the sections dropdown", "Sections dropdown is expanded successfully.");

                }
//                        DriverAction.waitSec(2);
                DriverAction.click(sections.get(k));
                int totalQues = DriverAction.getElements(MyLocators.paletteBtn).size();
                for (int i = 0; i < totalQues; i++) {
                    //  enterAnswer();
                    if (DriverAction.isExist(MyLocators.textarea)) {
                        DriverAction.typeText(MyLocators.textarea, "abc");
                        GemTestReporter.addTestStep("Enter answer in input field", "Successfully entered the answer in input field", STATUS.PASS);
                    } else if (DriverAction.isExist(MyLocators.mcqOptions)) {
                        DriverAction.click(MyLocators.selectOption, "Select an option");
                        GemTestReporter.addTestStep("Select an answer", "Successfully selected an answer.", STATUS.PASS);
                    } else {
                        DriverAction.click(MyLocators.selectCheckbox, "Select an option");
                        GemTestReporter.addTestStep("Select an answer", "Successfully selected the answer", STATUS.PASS);
                    }
                    DriverAction.scrollToBottom();
                    DriverAction.click(By.xpath(MyLocators.button.replace("input", "Save & Next")));


                }
                sections = DriverAction.getElements(MyLocators.totalSections);
            }

            //Finish test
            DriverAction.click(By.xpath(MyLocators.button.replace("input", "Finish Test")));
            DriverAction.click(By.xpath(MyLocators.testSubmitButton.replace("input", "Yes")));
            //validate the score board
            DriverAction.waitSec(5);
            if (DriverAction.isExist(MyLocators.testSummary, 2)) {
                GemTestReporter.addTestStep("Verify candidate is navigates to test summary screen and Score of test are Visible", "Successfully verified the test summary screen.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify candidate is navigates to test summary screen and Score of test are Visible", "Could not verify the test summary screen.", STATUS.FAIL);
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.scoreBoard)) {
                GemTestReporter.addTestStep("Verify Score after Submission of Test ", "Score is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Score after Submission of Test ", "Score is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.scrollToBottom();
            if (DriverAction.isExist(LearnerModule_Locators.proceedBtn, 10)) {
                DriverAction.click(LearnerModule_Locators.proceedBtn);
            }
//Navigate to Dashboard

            if (DriverAction.isExist(MyLocators.backToDashboard, 10)) {
                DriverAction.click(MyLocators.backToDashboard);
            }
            DriverAction.waitSec(5);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Validate Test Reattempt$")
    public void tesReattemptValidation() {
        try {
            DriverAction.scrollToBottom();
            if (DriverAction.isExist(LearnerModule_Locators.proceedBtn, 10)) {
                DriverAction.click(LearnerModule_Locators.proceedBtn);
            }
//Navigate to Dashboard

            if (DriverAction.isExist(MyLocators.backToDashboard, 10)) {
                DriverAction.click(MyLocators.backToDashboard);
            }
            DriverAction.waitSec(5);
            //Switch the tab to completed
            if (DriverAction.isExist(Tests_TestControl_Locators.completedTab, 10)) {
                DriverAction.click(Tests_TestControl_Locators.completedTab);
            }
            //validate the Reattempt button on the Required test
            String testNameHeading = DriverAction.getElementText(Tests_TestControl_Locators.testHeading);
            if (testNameHeading.equals(testName)) {
                if (DriverAction.isDisplayed(Tests_TestControl_Locators.reattemptBtn)) {
                    GemTestReporter.addTestStep("Verify After Selecting Test Reattempt filter Learner able to  Reattempt the test ", "Yes Learner able to Reattempt the test", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify After Selecting Test Reattempt filter Learner able to  Reattempt the test ", "No Learner not able to Reattempt", STATUS.FAIL, DriverAction.takeSnapShot());
                }
            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Check the Required Checkbox Filter \"([^\"]*)\"$")
    public void checkboxFilter(String option) {
        try {
            if (DriverAction.isExist(By.xpath(Tests_TestControl_Locators.checkbox.replace("itr", option)), 10)) {
                DriverAction.click(By.xpath(Tests_TestControl_Locators.checkbox.replace("itr", option)));
            } else {
                GemTestReporter.addTestStep("Verify Required Checkbox is Visible", "It is not Visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Validate Candidate Report$")
    public void candidateReport() {
        try {
            //navigate Test Control screen
            if (DriverAction.isExist(MyLocators.sidebar, 120)) {
                DriverAction.click(MyLocators.sidebar, "Expand the sidebar", "Sidebar expands displaying list of modules.");
            }

            //select a module from sidebar
            if (DriverAction.isExist(By.xpath(MyLocators.selectModule.replace("input", "Tests")), 120)) {
                DriverAction.click(By.xpath(MyLocators.selectModule.replace("input", "Tests")));
            }
            //select submodule if required
            if (DriverAction.isExist(By.xpath(MyLocators.selectModule.replace("input", "Test Control")), 120)) {
                DriverAction.click(By.xpath(MyLocators.selectModule.replace("input", "Test Control")));
            }

            //close sidebar
            DriverAction.click(MyLocators.crossIcon, "Click the cross icon of sidebar", "Successfully clicked the cross icon.");
//Filter the Created Test in Test Control screen

            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            } else {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInputInternal, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.threeDotIcon, 20)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidate Report")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidate Report")));
                }
            } else {
                DriverAction.click(Tests_TestControl_Locators.threeDotInternal);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidate Report")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidate Report")));
                }
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.statusColumn)) {
                String status = DriverAction.getElementText(Tests_TestControl_Locators.statusColumn);
                if (status != "Unattempted") {
                    GemTestReporter.addTestStep("Verify Candidate have completed the test or not", "Candidate Successfully Completed the Test", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify Candidate have completed the test or not", "Candidate have not attempted the Test", STATUS.FAIL, DriverAction.takeSnapShot());

                }
            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @Then("^Validate Test Summary Report \"([^\"]*)\"$")
    public void testSummaryReport(String campus) {
        try {
//            DriverAction.scrollToBottom();
//            if (DriverAction.isExist(LearnerModule_Locators.proceedBtn, 10)) {
//                DriverAction.click(LearnerModule_Locators.proceedBtn);
//            }
////Navigate to Dashboard
//
//            if (DriverAction.isExist(MyLocators.backToDashboard, 10)) {
//                DriverAction.click(MyLocators.backToDashboard);
//            }
//            DriverAction.waitSec(5);
//            //Switch the user to Super admin
//            //logout from the account
//            if (DriverAction.isDisplayed(Course_Locators.navbarDropdown)) {
//                DriverAction.click(Course_Locators.navbarDropdown, "Click on the Dropdown button", "successfully clicked Dropdown button.");
//                if (DriverAction.isDisplayed(Tests_TestControl_Locators.logout)) {
//                    DriverAction.click(Tests_TestControl_Locators.logout, "Click on Logout Option", "successfully select Logout option.");
//                }
//            }
//            //login as candidate
//            if (DriverAction.isDisplayed(MyLocators.usernameField)) {
//                DriverAction.typeText(MyLocators.usernameField, "rahul23@gmail.com");
//            }
//            if (DriverAction.isDisplayed(MyLocators.passwordField)) {
//                DriverAction.typeText(MyLocators.passwordField, "abc@123");
//            }
//            DriverAction.waitUntilElementClickable(MyLocators.loginBtn, 90);
//            if (DriverAction.isDisplayed(MyLocators.loginBtn)) {
//                DriverAction.click(MyLocators.loginBtn, "Clicked on Login Button", "Successfully Clicked on Login Button");
//            }
//
//            //wait while the page loads.
//            if (DriverAction.isExist(MyLocators.spinner)) ;
//            DriverAction.waitUntilElementDisappear(MyLocators.spinner, 20);

            //navigate Test Control screen
            if (DriverAction.isExist(MyLocators.sidebar, 120)) {
                DriverAction.click(MyLocators.sidebar, "Expand the sidebar", "Sidebar expands displaying list of modules.");
            }

            //select a module from sidebar
            if (DriverAction.isExist(By.xpath(MyLocators.selectModule.replace("input", "Tests")), 120)) {
                DriverAction.click(By.xpath(MyLocators.selectModule.replace("input", "Tests")));
            }
            //select submodule if required
            if (DriverAction.isExist(By.xpath(MyLocators.selectModule.replace("input", "Test Control")), 120)) {
                DriverAction.click(By.xpath(MyLocators.selectModule.replace("input", "Test Control")));
            }

            //close sidebar
            DriverAction.click(MyLocators.crossIcon, "Click the cross icon of sidebar", "Successfully clicked the cross icon.");
//Filter the Created Test in Test Control screen

            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.threeDotIcon, 120)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Test Summary")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Test Summary")));
                }
            }
            DriverAction.waitSec(5);
            String heading = DriverAction.getElementText(Tests_TestControl_Locators.summaryHeading);
            if (heading.equals(testName)) {
                GemTestReporter.addTestStep("Verify Test Name Match with Report", "Test Name Matched with Report", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Test Name Match with Report", "Test Name is not Matched with Report", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            String reportCampus = DriverAction.getElementText(Tests_TestControl_Locators.summaryCampus);
            if (campus.equals(reportCampus)) {
                GemTestReporter.addTestStep("Verify Test Name Match with Report", "Campus Name is not Matched with Report", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Test Name Match with Report", "Campus Name is not Matched with Report", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @Then("^Create and Validate Copy of Test \"([^\"]*)\"$")
    public void validateCopyOfTest(String endDate) {
        try {

//Filter the Created Test in Test Control screen

            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.threeDotIcon, 120)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Copy Test")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Copy Test")));
                }
            }
            DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon, 120);
            DriverAction.scrollToBottom();
            DriverAction.click(By.xpath(Tests_TestControl_Locators.calendar.replace("itr", "2")));
            DriverAction.waitSec(3);
            DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date", endDate)));
            if (DriverAction.isExist(By.xpath(MyLocators.button.replace("input", "Next")), 120)) {
                DriverAction.click(By.xpath(MyLocators.button.replace("input", "Next")));
            }
            if (DriverAction.isExist(Tests_TestControl_Locators.continueButton, 120)) {
                DriverAction.click(Tests_TestControl_Locators.continueButton);
            }
            //filter and validate the copy Test
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, "Copy Of " + testName);
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.createdTestText)) {
                String fetchedTestName = DriverAction.getElementText(Tests_TestControl_Locators.createdTestText);
                System.out.println(fetchedTestName);
                String copyTest = "Copy Of " + testName;
                System.out.println(copyTest);
                if (copyTest.equals(fetchedTestName)) {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is Created Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Verify Test is Created ", "Test is not Created Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                }

            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Edit and Validate Created Test$")
    public void editAndValidate() {
        try {
            //Filter the Created Test in Test Control screen

            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.threeDotIcon, 120)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Edit Test")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Edit Test")));
                }
            }
            DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon, 120);
            DriverAction.scrollToBottom();
//            DriverAction.click(By.xpath(Tests_TestControl_Locators.calendar.replace("itr","2")));
//            DriverAction.waitSec(3);
//            DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date",endDate)));
            //edit the Test Name

            if (DriverAction.isExist(Tests_TestControl_Locators.testNameInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testNameInput, "Edit " + testName);
            }
//            DriverAction.scrollToBottom();
            if (DriverAction.isExist(By.xpath(MyLocators.button.replace("input", "Next")), 120)) {
                DriverAction.click(By.xpath(MyLocators.button.replace("input", "Next")));
            }
            if (DriverAction.isExist(Tests_TestControl_Locators.continueButton, 120)) {
                DriverAction.click(Tests_TestControl_Locators.continueButton);
            }
            //filter and validate the copy Test
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, "Edit " + testName);
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.createdTestText)) {
                String fetchedTestName = DriverAction.getElementText(Tests_TestControl_Locators.createdTestText);
                System.out.println(fetchedTestName);
                String editTest = "Edit " + testName;
                System.out.println(editTest);
                if (editTest.equals(fetchedTestName)) {
                    GemTestReporter.addTestStep("Verify Test is Edited ", "Test is Edited Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Verify Test is Edited ", "Test is not Edited Successfully", STATUS.PASS, DriverAction.takeSnapShot());

                }

            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @Then("^Assign Candidate and Verify it$")
    public void verifyAssignedCandidate() {
        try {
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInput, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInput, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isExist(Tests_TestControl_Locators.threeDotIcon, 120)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")));
                }
            }
            DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon, 120);
            DriverAction.scrollToBottom();
            //Assign the user
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.filterInput)) {
                DriverAction.typeText(Tests_TestControl_Locators.filterInput, "rahul22@gmail.com");
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(Course_Locators.addIcon)) {
                    DriverAction.click(Course_Locators.addIcon, "Clicked on add Content Icon", "Successfully clicked on Add Content Icon");
                }
            }
            //switch the user
            if (DriverAction.isDisplayed(Course_Locators.navbarDropdown)) {
                DriverAction.click(Course_Locators.navbarDropdown, "Click on the Dropdown button", "successfully clicked Dropdown button.");
                if (DriverAction.isDisplayed(Tests_TestControl_Locators.logout)) {
                    DriverAction.click(Tests_TestControl_Locators.logout, "Click on Logout Option", "successfully select Logout option.");
                }
            }
            //login as candidate
            if (DriverAction.isDisplayed(MyLocators.usernameField)) {
                DriverAction.typeText(MyLocators.usernameField, "rahul22@gmail.com");
            }
            if (DriverAction.isDisplayed(MyLocators.passwordField)) {
                DriverAction.typeText(MyLocators.passwordField, "abc@123");
            }
            DriverAction.waitUntilElementClickable(MyLocators.loginBtn, 90);
            if (DriverAction.isDisplayed(MyLocators.loginBtn)) {
                DriverAction.click(MyLocators.loginBtn, "Clicked on Login Button", "Successfully Clicked on Login Button");
            }

            //wait while the page loads.
            if (DriverAction.isExist(MyLocators.spinner)) ;
            DriverAction.waitUntilElementDisappear(MyLocators.spinner, 20);

            //verify dashboard is displayed on login
            if (DriverAction.isExist(MyLocators.dashboard)) {
                GemTestReporter.addTestStep("Verify dashboard is displayed", "Successfully displayed the dashboard.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(Tests_TestControl_Locators.activeTestHeadingList, 120)) {
                List<WebElement> list1 = DriverAction.getElements(Tests_TestControl_Locators.activeTestHeadingList);
                String testHeading = DriverAction.getElementText(list1.get(list1.size() - 1));
                if (testHeading.equals(testName)) {
                    GemTestReporter.addTestStep("Verify Candidate is assigned", "Candidate is Assigned Successfully", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify Candidate is assigned", "Candidate is not Assigned Successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                }
            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Switch the User \"([^\"]*)\", \"([^\"]*)\"$")
    public void switchUser(String userName, String passWord) {
        try {

            //Switch the user to Super admin
            //logout from the account
            if (DriverAction.isDisplayed(Course_Locators.navbarDropdown)) {
                DriverAction.click(Course_Locators.navbarDropdown, "Click on the Dropdown button", "successfully clicked Dropdown button.");
                if (DriverAction.isDisplayed(Tests_TestControl_Locators.logout)) {
                    DriverAction.click(Tests_TestControl_Locators.logout, "Click on Logout Option", "successfully select Logout option.");
                }
            }
            if (DriverAction.isDisplayed(MyLocators.usernameField)) {
                DriverAction.typeText(MyLocators.usernameField, userName);
            }
            if (DriverAction.isDisplayed(MyLocators.passwordField)) {
                DriverAction.typeText(MyLocators.passwordField, passWord);
            }
            DriverAction.waitUntilElementClickable(MyLocators.loginBtn, 90);
            if (DriverAction.isDisplayed(MyLocators.loginBtn)) {
                DriverAction.click(MyLocators.loginBtn, "Clicked on Login Button", "Successfully Clicked on Login Button");
            }

            //wait while the page loads.
            if (DriverAction.isExist(MyLocators.spinner)) ;
            DriverAction.waitUntilElementDisappear(MyLocators.spinner, 20);


        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^check the checkbox \"([^\"]*)\"$")
    public void checkCheckBox(String checkboxLabel) {
        try {
            if (DriverAction.isExist(By.xpath(Tests_TestControl_Locators.checkboxDiv.replace("input", checkboxLabel)), 120)) {
                DriverAction.click(By.xpath(Tests_TestControl_Locators.checkboxDiv.replace("input", checkboxLabel)));
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

    @And("^Add Test Info for Internal Test  \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void addTestInfoInternal(String testTag, String duration, String level, String startDate, String endDate) {
        try {
            int c = 2;
            int c1 = 1;
            List<WebElement> inputFields = new ArrayList<>();
            if (DriverAction.isExist(Tests_TestControl_Locators.testInputFields, 120)) {
                inputFields = DriverAction.getElements(Tests_TestControl_Locators.testInputFields);
            } else {
                inputFields = DriverAction.getElements(Tests_TestControl_Locators.testInputFieldsInternal);
            }
            testName = RandomStringUtils.randomAlphanumeric(10);
            String inputValues[] = {testName, testTag, duration, level, startDate, endDate};
            for (int i = 1; i <= 6; i++) {
                String dropdown = inputFields.get(i).getAttribute("aria-haspopup");
                String calendar = inputFields.get(i).getAttribute("id");
//           String upload = inputFields.get(i).getAttribute("type");
                //dropdown
                if (dropdown != null && dropdown.equals("listbox")) {

                    DriverAction.click(By.xpath(Course_Locators.dropdownIcon.replace("itr", String.valueOf(c))));
                    DriverAction.click(By.xpath(Course_Locators.option.replace("input", inputValues[i - 1])));
                    c++;
                }
                //calendar
                if (calendar != null && (calendar.equals("calendar1") || calendar.equals("calendar2"))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.calendar.replace("itr", String.valueOf(c1))));
                    DriverAction.waitSec(3);
                    if (c1 == 1) {
//                   DriverAction.click(By.xpath("//span[text()='12']"));
                        DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date", startDate)));
                    } else if (c1 == 2) {
//                   DriverAction.click(By.xpath("//span[text()='13']"));
                        DriverAction.click(By.xpath(Tests_TestControl_Locators.date.replace("date", endDate)));
                    }
                    c1++;
                }
                //textbox
                else {
                    DriverAction.waitSec(3);
                    DriverAction.typeText(inputFields.get(i), inputValues[i - 1]);
                }
            }
            DriverAction.scrollToBottom();
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @Then("^Assign the Internal test to Learner$")
    public void assignTestLearner() {
        try {
            if (DriverAction.isExist(Tests_TestControl_Locators.testControlFilterInputInternal, 120)) {
                DriverAction.typeText(Tests_TestControl_Locators.testControlFilterInputInternal, testName);
            }
            DriverAction.waitSec(5);
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.threeDotInternal)) {
                DriverAction.click(Tests_TestControl_Locators.threeDotInternal);
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")))) {
                    DriverAction.click(By.xpath(Tests_TestControl_Locators.threeDotOption.replace("input", "Candidates Assigned")));
                }
            }
            if (DriverAction.isDisplayed(Tests_TestControl_Locators.filterInput)) {
                DriverAction.typeText(Tests_TestControl_Locators.filterInput, "rahul44@gmail.com");
                DriverAction.waitSec(5);
                if (DriverAction.isDisplayed(Course_Locators.addIcon)) {
                    DriverAction.click(Course_Locators.addIcon, "Clicked on add Content Icon", "Successfully clicked on Add Content Icon");
                }
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Enter course description", "Exception encountered- " + e, STATUS.ERR);
        }
    }

}