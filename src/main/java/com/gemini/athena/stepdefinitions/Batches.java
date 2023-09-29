package com.gemini.athena.stepdefinitions;

import com.gemini.athena.locators.MyLocators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Batches {
    String courseName="";
    String email="";
    String batchName="";
    String courseState="";

    @And("^Click actions icon of a batch$")
    public void batchActionsIcon(){
        try {
            Thread.sleep(2000);
            DriverAction.click(MyLocators.batchActionsIcon);
            GemTestReporter.addTestStep("Click actions icon of batch","Successfully clicked the actions icon", STATUS.PASS);
        }catch (Exception e){
            GemTestReporter.addTestStep("Click actions icon of batch","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @And("^Select \"([^\"]*)\" from actions dropdown$")
    public void selectFromActionsDropdown(String option) throws InterruptedException {
        Thread.sleep(5000);
        courseState=option;
        DriverAction.click(By.xpath(MyLocators.editOptions.replace("input",option)));
    }

    @And("^Add a course in batch$")
    public void addCourseInBatch() {
        try{
            Thread.sleep(3000);
            DriverAction.click(MyLocators.addCourse);
      //      wait(2000);


            List<WebElement>addedCourses=DriverAction.getElements(MyLocators.addedCourseName);
            int total= addedCourses.size();
            courseName=DriverAction.getElementText(addedCourses.get(total-1));
          //  courseName=DriverAction.getElementText(text);
            GemTestReporter.addTestStep("Add course in a batch","Successfully added the course- "+courseName+" in batch.",STATUS.PASS);
        }catch(Exception e){
            GemTestReporter.addTestStep("Add course in a batch","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @Then("^Verify added course displays in batch summary$")
    public void verifyCourseInBatchSummary() {
        try {
            Thread.sleep(5000);
            DriverAction.scrollToBottom();
            List<WebElement>courses=DriverAction.getElements(MyLocators.recentlyAddedCourse);
            int total= courses.size();
            String course = DriverAction.getElementText(courses.get(total-1));
            if (course.contains(courseName)) {
                GemTestReporter.addTestStep("Verify added course displays in batch summary", "Successfully verified added course displays in batch summary.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify added course displays in batch summary", "Could not verify added course displays in batch summary.", STATUS.FAIL);
            }
        }catch(Exception e){

            GemTestReporter.addTestStep("Verify added course displays in batch summary","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @Then("^Get email of user$")
    public void getEmail() {
        try {
            email = DriverAction.getElementText(MyLocators.userEmail);
            GemTestReporter.addTestStep("Get email of user", "Successfully fetched the email- " +email, STATUS.PASS);
        }catch(Exception e){
            GemTestReporter.addTestStep("Get email of user","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @Then("^Verify owner of a batch is selected by default$")
    public void verifyOwnerOfBatchSelected() {
        try {
            String owner = DriverAction.getElementText(MyLocators.owner);
            if (email.contains(owner)) {
                GemTestReporter.addTestStep("Verify owner of a batch is selected by default", "Successfully verified the owner of batch is selected by default.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify owner of a batch is selected by default", "Could not verify owner of batch is selected by default.", STATUS.FAIL);
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Verify owner of a batch is selected by default","Exception encountered- "+e,STATUS.ERR);
        }

    }

    @And("^Enter respective values in batch fields \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterInBatchFields(String fileLocation, String owner) {

        try {
            List<WebElement> inputFields= DriverAction.getElements(MyLocators.batchInputFields);
            System.out.print(inputFields.size());
            batchName= RandomStringUtils.randomAlphanumeric(10);
            batchName="a"+batchName;
            String[] inputValues ={batchName,"",fileLocation,owner};
            int k=0;
            for(int i=0;i<inputFields.size();i++){
                if(i==1&&courseState.equals("Edit")){
                    continue;
                }
                Thread.sleep(2000);
                String dropdown=inputFields.get(i).getAttribute("aria-haspopup");
                String upload=inputFields.get(i).getAttribute("id");
                //dropdown
                if(dropdown!=null&&dropdown.equals("listbox")){
                    List<WebElement>dropdownFields=DriverAction.getElements(MyLocators.fieldsDropdown);

                    DriverAction.click(dropdownFields.get(k));
                    k++;
                    DriverAction.click(By.xpath(MyLocators.option.replace("input",inputValues[i])));
//                    if(DriverAction.isDisplayed(MyLocators.""crossIcon)){
//                        DriverAction.click(MyLocators.crossIcon);
//                    }
                }
                //file-upload
                else if(upload!=null&&(upload.equals("getFile"))){
                    DriverAction.fileUpload(inputFields.get(i),fileLocation);
                }
                //textbox
                else{
                    inputFields.get(i).clear();
                    DriverAction.typeText(inputFields.get(i),inputValues[i]);
                }

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Enter respective values in batch input fields", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @Then("^Verify batch is created/updated$")
    public void verifyBatchCreatedUpdated() {

        try {
          //  DriverAction.waitUntilElementAppear(MyLocators.batchCreated,10);
            Thread.sleep(15000);
            String batch = DriverAction.getElementText(MyLocators.batchCreated);
            if (batch.equals(batchName)) {
                GemTestReporter.addTestStep("Verify batch is created/updated", "Successfully verified the batch is created/updated.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify batch is created/updated", "Could not verify the created/updated batch", STATUS.FAIL);
            }
        }catch(Exception e){
                GemTestReporter.addTestStep("Verify batch is created/updated","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @And("^Click the button in batch \"([^\"]*)\"$")
    public void clickCreateBatch(String button) {
        DriverAction.click(By.xpath(MyLocators.createBatch.replace("input",button)));
    }
}
