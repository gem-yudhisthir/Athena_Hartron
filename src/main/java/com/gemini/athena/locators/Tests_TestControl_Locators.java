package com.gemini.athena.locators;

import org.openqa.selenium.By;

public class Tests_TestControl_Locators {
    public static String date = "//span[text()='date']";
    public static By testInputFields = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//input");

    public static By testInputFieldsInternal = By.xpath("//form[@class='ng-invalid ng-touched ng-dirty']//input");

    //form[@class='ng-invalid ng-touched ng-dirty']//input
    public static String calendar = "(//input[contains(@id,'calendar')])[itr]";

    public static By dropdown = By.xpath("(//span[contains(@class,'pi pi-chevron-down')])[2]");

    public static String option = "//span[text()='section']";

    public static By percentageInput = By.xpath("(//form[@class='p-ml-5 p-mr-5 ng-invalid ng-dirty ng-touched']//input)[2]");

    public static By timeInput = By.xpath("(//form[@class='p-ml-5 p-mr-5 ng-invalid ng-dirty ng-touched']//input)[3]");

    public static By addQuestion = By.xpath("//button//span[text()='Add Questions']");
    public static By importRandomBtn = By.xpath("//button//span[text()='Import Random']");

    public static By questionTypeDropdown = By.xpath("//div//span[text()='Question Type']");

    public static By difficultyDropdown = By.xpath("//div//span[text()='Difficulty']");

    public static By levelDropdown = By.xpath("//div//span[text()='Level']");

    public static By noOfQuestionInput = By.xpath("//span[@class='p-inputnumber p-component']//input");

    public static By submitButton = By.xpath("//button[text()=' Submit ']");

    public static String options = "//li//span[text()='input']";

    public static By saveButton = By.xpath("//button//span[text()='Save']");

    public static By continueButton = By.xpath("//button//span[text()='Continue']");

    public static By createdTestText = By.xpath("(//div[@class='p-datatable-wrapper ng-star-inserted']//table//tr//td)[1]");

    public static By createdTestTextInternal = By.xpath("(//div[@class='p-datatable-wrapper ng-star-inserted']//table)[2]//tr//td[1]");


    public static By threeDotIcon = By.xpath("(//span[contains(@class,'pi pi-ellipsis')])[1]");

    public static By threeDotInternal = By.xpath("(//span[contains(@class,'pi pi-ellipsis')])[11]");


    public static String threeDotOption = "//div//label[text()='input']";

    public static By filterInput = By.xpath("(//input[@type='text'])[2]");


    public static By logout = By.xpath("//span[text()='Logout']");


    public static By startTestBtn = By.xpath("//button[text()=' Start Test ']");

    public static By scoreBoard = By.xpath("//h4[text()='Summary']");

    public static By completedTab = By.xpath("//a//span[text()='Completed Tests']");

    public static By testHeading = By.xpath("(//div[@class='card-adjustments'])[2]//div[@class='rounded m-2 ng-star-inserted']//h6//div");

    public static By reattemptBtn = By.xpath("(//div[@class='card-adjustments'])[2]//div[@class='rounded m-2 ng-star-inserted']//button//span[text()='Reattempt']");

    public static String checkbox = "(//form[@class='ng-dirty ng-touched ng-valid']//div[@class='p-checkbox-box'])[itr]";

    public static By testControlFilterInput = By.xpath("//span[@class='p-input-icon-right p-ml-auto']//input");

    public static By testControlFilterInputInternal = By.xpath("(//span[@class='p-input-icon-right p-ml-auto']//input)[2]");


    public static By statusColumn = By.xpath("//span[@class='p-tag-value']");

    public static By activeTestHeadingList = By.xpath("(//div[@class='card-adjustments'])[1]//div[@class='rounded m-2 ng-star-inserted']//h6");

    public static String startBtn = "(//button[text()=' Start Test '])[itr]";

    public static By summaryHeading = By.xpath("(//h5[@class='test-heading']//b)[1]");

    public static By summaryCampus = By.xpath("(//h5[@class='test-heading']//b)[2]");

    public static By testNameInput = By.xpath("//input[@id='testName']");


    public static String buttonInternal = "(//button[@label='input'])[2]";
    public static String checkboxDiv = "//span[text()='input']/preceding-sibling::p-checkbox//div";


//span[text()='Internal Test']/preceding-sibling::p-checkbox//div


    //span[@class='p-tag-value']

//span[@class='p-input-icon-right p-ml-auto']//input


    //h4[text()='Summary']

    //button[text()=' Start Test ']


    //div//label[text()='Candidates Assigned']
//    (//span[contains(@class,'pi pi-ellipsis')])[1]


    //button//span[text()='Continue']

    //button//span[text()='Save']

//button[text()=' Submit ']
    //div//span[text()='Question Type']
    //div//span[text()='Difficulty']
    //div//span[text()='Level']
    //div//span[@class='p-inputnumber p-component']

    //button//span[text()='Import Random']

    //button//span[text()='Add Questions']

    //label[text()='HH:MM*']
    //label[text()='Cut Off Percentage*']

}