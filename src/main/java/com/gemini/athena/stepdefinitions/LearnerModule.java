package com.gemini.athena.stepdefinitions;

        import com.gemini.athena.locators.Course_Locators;
        import com.gemini.athena.locators.LearnerModule_Locators;
        import com.gemini.athena.locators.MyLocators;
        import com.gemini.generic.reporting.GemTestReporter;
        import com.gemini.generic.reporting.STATUS;
        import com.gemini.generic.ui.utils.DriverAction;
        import com.gemini.generic.ui.utils.DriverManager;
        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;

        import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.io.File;
        import java.util.*;
        import java.util.List;

public class LearnerModule {
    Logger logger = LoggerFactory.getLogger(LearnerModule.class);

    @When("^Expand user dropdown from navbar$")
    public void expandUserDropdown() {
        DriverAction.click(LearnerModule_Locators.userDropdown, "Click the dropdown icon on navbar", "Successfully clicked the dropdown icon.");

    }

    @Then("^Verify the options present in dropdown and select it \"([^\"]*)\"$")
    public void verifyOptionsInDropdown(String option) {

        try {
            //In this function we are validating the dropdown option with given option.
            boolean found = false;
            List<WebElement> options = DriverAction.getElements(LearnerModule_Locators.optionList);
            System.out.println(options.size());
            for (WebElement option1 : options) {
                String optionText = option1.getText();
                if (optionText.equals(option)) {
                    found = true;
                }
                System.out.println(optionText);
            }
            if (!found) {
                GemTestReporter.addTestStep("Verify the option present in dropdown", "Could not verify the option- " + option + "", STATUS.FAIL, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Verify the option present in dropdown", "Successfully verified the option- " + option + "", STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.click(LearnerModule_Locators.requiredOption, "Select " + option + " from dropdown", "Successfully selected " + option + ".");


        } catch (Exception e) {
            GemTestReporter.addReasonOfFailure(e + " Exception occured while verifying the options present in dropdown.");
        }
    }

    @And("^Verify View Course Button and click it$")
    public void verifyViewCourse() {
        try {
            //Validating View Course button and it functionality.
            DriverAction.waitUntilElementAppear((LearnerModule_Locators.courseCatalogbtn),20);
            DriverAction.scrollToBottom();
            if (DriverAction.getElement(LearnerModule_Locators.viewCourseBtn).isDisplayed()) {
                DriverAction.scrollToBottom();
                GemTestReporter.addTestStep("Verify View Course button is present", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(LearnerModule_Locators.viewCourseBtn);
//                DriverAction.waitSec(10);
                DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
            } else {
                GemTestReporter.addTestStep("Verify View Course button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }

    }

    @And("^Validate Resume Course after starting the course$")
    public void verifyResume() {
        try {
//            DriverAction.scrollToBottom();
            if (DriverAction.getElement(LearnerModule_Locators.startCourseBtn).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Start Course button is present", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(LearnerModule_Locators.startCourseBtn);
                DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
//                DriverAction.waitSec(10);
                DriverAction.scrollToBottom();
                if (DriverAction.getElement(LearnerModule_Locators.backBtn).isDisplayed()) {
                    DriverAction.click(LearnerModule_Locators.backBtn);
                    if (DriverAction.getElement(LearnerModule_Locators.resumeBtn).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify Resume Course button is present", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        DriverAction.click(LearnerModule_Locators.backBtn1);
                        if (DriverAction.getElement(LearnerModule_Locators.resumeBtn2).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify Resume button is present", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify Resume button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                        }

                    } else {
                        GemTestReporter.addTestStep("Verify Resume Course button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                }

            } else {
                GemTestReporter.addTestStep("Verify Start Course button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @And("^Complete the Course and Download the certificate$")
    public void CompleteCourse() {
        try {
            //In this we are completing the course and downloading the certificate.
//            DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
            DriverAction.waitSec(10);
            DriverAction.scrollToBottom();
            if (DriverAction.getElement(LearnerModule_Locators.resumeBtn2).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Resume button is present", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(LearnerModule_Locators.resumeBtn2);
                if (DriverAction.getElement(LearnerModule_Locators.resumeBtn).isDisplayed()) {
                    DriverAction.click(LearnerModule_Locators.resumeBtn);
                    if (DriverAction.getElement(LearnerModule_Locators.vedio).isDisplayed()) {
                        DriverAction.click(LearnerModule_Locators.vedio);
                    }
//                    DriverAction.waitSec(11);
                    DriverAction.waitUntilElementClickable((LearnerModule_Locators.completeAndContinueBtn),90);
                    if(DriverAction.isEnabled(LearnerModule_Locators.completeAndContinueBtn))
                    {
                        DriverAction.click(LearnerModule_Locators.completeAndContinueBtn);
                        DriverAction.waitSec(3);
                        if (DriverAction.getElement(LearnerModule_Locators.popupDiv).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        if(DriverAction.isDisplayed(LearnerModule_Locators.greenTick))
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Successful", STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        else
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

                        }
                    }
//                    DriverAction.waitSec(30);
                    DriverAction.waitUntilElementClickable((LearnerModule_Locators.completeAndContinueBtn),90);

                    if(DriverAction.isEnabled(LearnerModule_Locators.completeAndContinueBtn))
                    {
                        DriverAction.click(LearnerModule_Locators.completeAndContinueBtn);
                        DriverAction.waitSec(3);
                        if (DriverAction.getElement(LearnerModule_Locators.popupDiv).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        if(DriverAction.isDisplayed(LearnerModule_Locators.greenTick))
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Successful", STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        else
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

                        }
                    }
                    //assignment
                    DriverAction.typeText(LearnerModule_Locators.answerArea, "demo_content");
//                            DriverAction.waitSec(10);
                    DriverAction.waitUntilElementClickable((LearnerModule_Locators.completeAndContinueBtn),90);

                    if(DriverAction.isEnabled(LearnerModule_Locators.completeAndContinueBtn))
                    {
                        DriverAction.click(LearnerModule_Locators.completeAndContinueBtn);
                        DriverAction.waitSec(3);
                        if (DriverAction.getElement(LearnerModule_Locators.assignmentPopup).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify confirmation popup message", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        if(DriverAction.isDisplayed(LearnerModule_Locators.greenTick))
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Successful", STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        else
                        {
                            GemTestReporter.addTestStep("Verify green tick once the module is completed", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

                        }
                    }
                    //test
                    if(DriverAction.getElement(LearnerModule_Locators.yesBtn).isDisplayed())
                    {
                        DriverAction.click(LearnerModule_Locators.yesBtn);
                    }
                    //click the next button to forward the vedio.
                    DriverAction.waitUntilElementClickable(By.xpath(MyLocators.nextBtn.replace("input","NEXT")), 90);
                    DriverAction.click(By.xpath(MyLocators.nextBtn.replace("input","NEXT")),"Click the NEXT button displayed in video","Successfully clicked the NEXT button displayed in video.");
                    //check the instruction checkbox
                    DriverAction.click(MyLocators.instructionsCheckbox);
                    GemTestReporter.addTestStep("Check the instructions checkbox", "Successfully checked the instructions checkbox.", STATUS.PASS);
                    DriverAction.click(By.xpath(MyLocators.button.replace("input","NEXT")));
                    //verify dailogue box appear
                    if (DriverAction.isExist(MyLocators.startTestDialog)) {
                        GemTestReporter.addTestStep("Verify confirmation dialog box appears", "Successfully verified the confirmations dialog box.", STATUS.PASS);
                    } else {
                        GemTestReporter.addTestStep("Verify confirmation dialog box appears", "Could not verify confirmation dialog box.", STATUS.FAIL);
                    }
                    DriverAction.click(MyLocators.yesBtn,"Click the yes button","Successfully clicked Yes button.");
                    //click attempt button
                    DriverAction.click(By.xpath(MyLocators.button.replace("input","Attempt")));
                    //expand section
                    DriverAction.click(MyLocators.sectionsDropdown, "Click the sections dropdown", "Sections dropdown is expanded successfully.");
                    List<WebElement>sections=DriverAction.getElements(MyLocators.totalSections);
                    int numOptions=sections.size();
                    for(int k=0;k<numOptions;k++) {
                        if(k!=0) {
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
                            DriverAction.click(By.xpath(MyLocators.button.replace("input","Save & Next")));
                            //clickTheButton("Save & Next");

                        }
                        sections=DriverAction.getElements(MyLocators.totalSections);
                    }

                    //Finish test
                    DriverAction.click(By.xpath(MyLocators.button.replace("input","Finish Test")));
//                    DriverAction.waitSec(5);
                    try {
                        // Create a Robot instance
                        Robot robot = new Robot();
                        robot.keyPress(KeyEvent.VK_ESCAPE);
                        robot.keyRelease(KeyEvent.VK_ESCAPE);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }

                    if (DriverAction.isExist(LearnerModule_Locators.finishSubmit)) {
                        DriverAction.click(LearnerModule_Locators.finishSubmit, "Finish and Submit button is visible on ui", "successfully clicked Finish and Submit button.");
                    } else {
                        GemTestReporter.addTestStep("Finish and Submit button is visible on ui", "Finish and Submit button is not visible on ui.", STATUS.FAIL);
                    }
                    DriverAction.waitSec(5);

                    if (DriverAction.isExist(LearnerModule_Locators.proceedBtn)) {
                        DriverAction.click(LearnerModule_Locators.proceedBtn, "proceed button is visible on ui", "successfully clicked proceed button.");
                    } else {
                        GemTestReporter.addTestStep("proceed button is visible on ui", "proceed button is not visible on ui.", STATUS.FAIL);
                    }
                    DriverAction.waitSec(5);

                    DriverAction.click(LearnerModule_Locators.backtoCourse, "back to course button is visible on ui", "successfully clicked back to course button.");
                    DriverAction.waitSec(5);

                    if (DriverAction.getElement(LearnerModule_Locators.downloadCertificate).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify download Certificate button is visible on ui", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        DriverAction.click(LearnerModule_Locators.downloadCertificate, "download Certificate button is visible on ui", "successfully clicked download Certificate button.");
//                        DriverAction.waitSec(10);
                        DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
                        String downloadPath = "C:/Users/rahul.adhikari/Downloads";
                        File latestFile = getLatestFileFromFolder(downloadPath);
                        System.out.println("Latest file: " + latestFile.getName());

                        if (latestFile.toString().contains("certificate")) {
                            System.out.println("File downloaded successfully.");
                            GemTestReporter.addTestStep("Verify certificate is downloaded properly", "Successful", STATUS.PASS, DriverAction.takeSnapShot());

                        } else {
                            System.out.println("File download failed.");
                            GemTestReporter.addTestStep("Verify certificate is downloaded properly", "UnSuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

                        }
//
                    } else {
                        GemTestReporter.addTestStep("Verify download Certificate button is visible on ui", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
//                    DriverAction.click(LearnerModule_Locators.downloadCertificate);

                }

                else {
                    GemTestReporter.addTestStep("Verify Resume course button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                }




            } else {
                GemTestReporter.addTestStep("Verify Resume button is present", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }

    }

    //validate test and assignment count
    @And("^validate test and assignment count matches$")
    public void validateCount() {
        try {
            //In this we are validating the count of assignment and test with actual count.
            if (DriverAction.getElement(LearnerModule_Locators.courseCatalogbtn).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.courseCatalogbtn);
            } else {
                GemTestReporter.addTestStep("Verify Course Catalog button is visible", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.waitUntilElementClickable(LearnerModule_Locators.courseDiv, 120);
            DriverAction.waitSec(6);
            String testCount = DriverAction.getElementText(LearnerModule_Locators.testCount);
            String[] count = testCount.split(" ");
            System.out.println(count[0]);
            int countTest = 0;
            int countAssignment = 0;
            if (count[0].equals("tests")) {
                countTest = 0;
            } else {
                countTest = Integer.parseInt(count[0]);
            }

            String assignmentCount = DriverAction.getElementText(LearnerModule_Locators.assignmentCount);

            String[] count1 = assignmentCount.split(" ");
            if (count1[0].equals("assignments")) {
                countAssignment = 0;
            } else {
                countAssignment = Integer.parseInt(count1[0]);
            }

            if (DriverAction.getElement(LearnerModule_Locators.viewCourseBtn1).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.viewCourseBtn1);
                DriverAction.scrollToBottom();
                List<WebElement> Assignments = DriverAction.getElements(LearnerModule_Locators.catalogAssignment);
                List<WebElement> testList1 = DriverAction.getElements(LearnerModule_Locators.catalogTest);
                System.out.print(testList1.size());
                if (Assignments.size() == countAssignment && testList1.size() == countTest) {
                    GemTestReporter.addTestStep("Verify test and assignment count for the view course", "Count Matches", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify test and assignment count for the view course", "Count Not Match", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            } else {
                GemTestReporter.addTestStep("Verify View Course button is visible", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }


    }

    @And("^Enroll in course and verify$")
    public void enrollCourse() {
        try {
            //In this we are enrolling in the course and validating.
            DriverAction.scrollToTop();
            if (DriverAction.getElement(LearnerModule_Locators.backBtn1).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.backBtn1);
                if (DriverAction.getElement(LearnerModule_Locators.startCourseBtn).isDisplayed()) {
                    DriverAction.click(LearnerModule_Locators.startCourseBtn);
                    if (DriverAction.getElement(LearnerModule_Locators.courseContent).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify Course is able to start after enroll from course catalog", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify Course is able to start after enroll from course catalog", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    DriverAction.click(LearnerModule_Locators.backBtn1);


                }


            } else {
                GemTestReporter.addTestStep("Verify back button is visible", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.waitUntilElementClickable(LearnerModule_Locators.courseDiv, 120);


        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }


    }

    @Then("^Apply Filter and validate the result for Course$")
    public void applyFilter() {
        try {
//In this we are applying the filter and validating the actual result is coming or not.
            if (DriverAction.getElement(LearnerModule_Locators.courseCatalogbtn).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.courseCatalogbtn);
            }
            DriverAction.waitSec(10);
            DriverAction.click(LearnerModule_Locators.courseDropdown);

            int catagoryCount = 0;
            String firstOption = DriverAction.getElementText(LearnerModule_Locators.courseFilterdiv);
            DriverAction.waitSec(5);
            DriverAction.click(LearnerModule_Locators.courseFilterdiv);

            boolean isTrue = true;
            while (isTrue) {
                DriverAction.waitSec(5);
                DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
                List<WebElement> catagory = DriverAction.getElements(LearnerModule_Locators.courseCatagory);
                System.out.println(catagory.size());

                for (int i = 1; i <= catagory.size(); i++) {
                    String reqLable = DriverAction.getElement(By.xpath(LearnerModule_Locators.courseCatagoryLable.replace("itr", String.valueOf(i)))).getText();
                    if (reqLable.equals(firstOption)) {
                        catagoryCount++;
                    }
                }
                DriverAction.scrollToBottom();
                DriverAction.waitSec(5);
                String paginator = DriverAction.getElementText(LearnerModule_Locators.catalogPaginator);
                System.out.println(paginator);
                String[] paginatorCount = paginator.split("\\n");
                System.out.println(paginatorCount[paginatorCount.length - 2]);
                String reqValue = paginatorCount[paginatorCount.length - 2];
                if (Integer.parseInt(reqValue) > catagoryCount) {
                    DriverAction.click(LearnerModule_Locators.footerRightArrow);
                } else if (Integer.parseInt(reqValue) == catagoryCount) {
                    GemTestReporter.addTestStep("Verify catagories filter in course catalog", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                    isTrue = false;
                }
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }

    }

    //This is the common function to get the latest modified file from the given directory.

    public static File getLatestFileFromFolder(String folderPath) {

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a valid directory.");
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            throw new RuntimeException("The folder is empty.");
        }

        // Sort files by last modified timestamp in descending order
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        return files[0];
    }

    @And("^Validate the count of Ongoing and Completed Course$")
    public void countValidation() {
        try {
            //In this we are validating the count of Ongoing and Completed course.
            int count = 0;
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
            String CompletedCount = DriverAction.getElementText(LearnerModule_Locators.completedCourseCount);
            String activeCount = DriverAction.getElementText(LearnerModule_Locators.activeCourseCount);

            for (int i = 1; i <= 3; i++) {
                DriverAction.waitSec(5);
                DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
                String CourseType = DriverAction.getElement(By.xpath(LearnerModule_Locators.courseType.replace("itr", String.valueOf(i)))).getText();
                DriverAction.click(By.xpath(LearnerModule_Locators.courseType.replace("itr", String.valueOf(i))));
                List<WebElement> list1 = DriverAction.getElements(By.xpath(LearnerModule_Locators.courseArea.replace("itr", String.valueOf(i))));
                if (CourseType.equals("Ongoing")) {
                    if (Integer.parseInt(activeCount) == list1.size()) {
                        GemTestReporter.addTestStep("Verify Count of Ongoing Course on ui", "Count Matched", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify Count of Ongoing Course on ui", "Count Not Matched", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else if (CourseType.equals("Completed")) {
                    if (Integer.parseInt(CompletedCount) == list1.size()) {
                        count = count + list1.size();
                        GemTestReporter.addTestStep("Verify Count of Completed Course on ui", "Count Matched", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify Count of Completed Course on ui", "Count Not Matched", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                } else if (CourseType.equals("Expired")) {
                    count = count + list1.size();
                }
            }
            String totalCount = DriverAction.getElementText(LearnerModule_Locators.totalCourseCount);
            if (Integer.parseInt(totalCount) == count) {
                GemTestReporter.addTestStep("Verify total count of Ongoing and completed course on ui", "Count Matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify total count of Ongoing and completed course on ui", "Count Not Matched", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @And("^Switch to Completed Tab and validate it functionality$")
    public void switchCompleted() {
        try {
            //In this we are validating after switching.
            if (DriverAction.getElement(LearnerModule_Locators.completedCourseTab).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.completedCourseTab);
                DriverAction.scrollToBottom();
                DriverAction.click(LearnerModule_Locators.threeDotIcon);
                if (DriverAction.getElement(LearnerModule_Locators.viewandDownload).isDisplayed()) {
                    DriverAction.click(LearnerModule_Locators.viewandDownload);
//                    DriverAction.waitSec(10);
                    DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);
                    if (DriverAction.getElement(LearnerModule_Locators.viewandDownloadLable).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify Certificate Visible on ui", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify Certificate Visible on ui", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    if (DriverAction.getElement(LearnerModule_Locators.downloadBtn).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify Download button on ui", "Successful", STATUS.PASS, DriverAction.takeSnapShot());
                        DriverAction.click(LearnerModule_Locators.downloadBtn);
//                        DriverAction.waitSec(5);
                        DriverAction.waitUntilElementDisappear(Course_Locators.loadingIcon,120);

                        String directoryPath = "C:/Users/rahul.adhikari/Downloads/";
                        File directory = new File(directoryPath);
                        if (directory.exists() && directory.isDirectory()) {
                            File latestfile = getLatestFile(directory);
                            if (latestfile != null) {
                                System.out.println("Latest File : " + latestfile.getAbsolutePath());
                                GemTestReporter.addTestStep("Validating weather User able to download certificate", "User successfully able to download the certificate", STATUS.PASS, DriverAction.takeSnapShot());

                            } else {
                                GemTestReporter.addTestStep("Validating weather User able to download certificate", "User not able to download the certificate", STATUS.FAIL, DriverAction.takeSnapShot());
                            }
                        } else {
                            GemTestReporter.addTestStep("Verify Download button on ui", "Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
                        }

                        DriverAction.click(LearnerModule_Locators.backBtn1);

                    }
                }

            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @And("^Validate Course Summary$")
    public void courseSummary() {
        try {
            if (DriverAction.getElement(LearnerModule_Locators.completedCourseTab).isDisplayed()) {
                DriverAction.click(LearnerModule_Locators.completedCourseTab);
                DriverAction.scrollToBottom();
                DriverAction.click(LearnerModule_Locators.threeDotIcon);
                DriverAction.waitSec(5);
                if (DriverAction.getElement(LearnerModule_Locators.courseSummary).isDisplayed()) {
                    DriverAction.click(LearnerModule_Locators.courseSummary);
                }

            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    public static File getLatestFile(File directory) {
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            return null;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }

}