package com.gemini.athena.stepdefinitions;

import com.gemini.athena.locators.QuestionsLocators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static com.gemini.athena.stepdefinitions.CandidateModule_UserManagement.*;

public class Questions {

    @And("^Select dropdown values in question fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void questionDropdownValues(String level,String type,String section,String difficulty,String skills){
        try {
            String[] fields = {level, type, section, difficulty, skills};
            String[] fieldName = {"level", "type", "section", "difficulty", "skills"};
            List<WebElement> dropdowns = DriverAction.getElements(QuestionsLocators.dropdownFields);
            for (int i = 0; i < dropdowns.size(); i++) {
                DriverAction.click(dropdowns.get(i));
                DriverAction.click(By.xpath(QuestionsLocators.dropdownValue.replace("input", fields[i])));
                GemTestReporter.addTestStep("Select " + fields[0] + " in " + fieldName[i], "Successfully selected " + fields[0], STATUS.PASS);
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Select dropdown values in question fields","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @And("Enter marks {string}")
    public void enterMarks(String marks) {
        try {
            DriverAction.typeText(QuestionsLocators.marksField, marks);
            GemTestReporter.addTestStep("Enter marks-" + marks + " in marks field", "Successfully entered the marks- " + marks, STATUS.PASS);
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter marks","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @And("Enter question description {string}")
    public void enterQuestionDescription(String questionStatement) {
        try {
            DriverAction.waitSec(4);
            DriverAction.typeText(QuestionsLocators.questionBox, questionStatement);
            GemTestReporter.addTestStep("Enter question description","Successfully added the question- "+questionStatement,STATUS.PASS);
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter question description","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @And("^Enter options and select a correct option$")
    public void enterOptions() {
        try {
            String text = "";
            String mail="";
            for (int i = 0; i < 3; i++) {
                //call generate unique mail function and remove @gmail.com
                mail=generateUniqueEmail();
                //generate unique string
                text=mail.replace("@gmail.com","a");
                //enter option and add
                DriverAction.typeText(QuestionsLocators.optionsBox, text);
                DriverAction.click(QuestionsLocators.addButton,"Click the add button");
                GemTestReporter.addTestStep("Enter option- "+text,"Successfully added the option- "+text,STATUS.PASS);
            }
            DriverAction.click(QuestionsLocators.selectOption,"Successfully selected the option");
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter options","Exception encountered- "+e,STATUS.ERR);
        }
    }

    @Then("^Verify the question is created \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyQuestionIsCreated(String question1, String question2) {
        try {
            String[] ques = {question2, question1};
            List<WebElement> questions = DriverAction.getElements(QuestionsLocators.firstColumn);
            int c = 0;
            for (int i = 0; i <= 1; i++) {
                String quesStatement = DriverAction.getElementText(questions.get(i));
                if (quesStatement.contains(ques[i])) {
                    c++;
                }
            }
            if (c == 2) {
                GemTestReporter.addTestStep("Verify question is saved", "Successfully verified that question is saved.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify question is saved", "Could not verify that question is saved.", STATUS.FAIL);
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Verify the question is saved","Exception encountered- "+e,STATUS.ERR);
        }
    }
}
