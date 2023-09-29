package com.gemini.athena.locators;

import org.openqa.selenium.By;

public class LearnerModule_Locators {

    public static By userDropdown = By.xpath("(//div[@class='ng-tns-c114-12 p-dropdown p-component']//span)[2]");

    public static By courseDropdown = By.xpath("(//div[contains(@class, 'p-dropdown-trigger ng-tns')]//span)[2]");
    public static By requiredOption = By.xpath("//span[text()='Learner']");
    public static By catalogPaginator = By.xpath("//span[@class='paginator-text-style']");
    public static By optionList = By.xpath("//ul[@class='p-dropdown-items ng-tns-c114-12']//span");
    public static By viewCourseBtn = By.xpath("//button//span[text()='View Course']");
    public static By startCourseBtn = By.xpath("//span[text()='Start Course']");

    public static By enrollBtn1 = By.xpath("(//span[text()='Enroll'])[2]");
    public static By backBtn = By.xpath("//button[text()=' Back ']");
    public static By resumeBtn = By.xpath("//span[text()='Resume Course']");
    public static By backBtn1 = By.xpath("//span[text()='Back']");
    public static By courseSummary = By.xpath("//label[text()='Course Summary']");

    public static By enrollBtn = By.xpath("//span[text()='Enroll']");
    public static By resumeBtn2 = By.xpath("(//span[text()='Resume'])[1]");
    public static By completeAndContinueBtn = By.xpath("//button[text()=' Complete and Continue ']");

    public static By moduleList = By.xpath("//div[contains(@class, 'p-accordion-content')]//div[@class='ng-star-inserted']");

    public static By readingModule = By.xpath("//div[contains(@class, 'p-accordion-content')]//img");

    public static By Assignment = By.xpath("//div[contains(@class, 'p-accordion-content')]//i[@class='pi pi-file ng-star-inserted']");
    public static By catalogAssignment = By.xpath("//div[contains(@class, 'p-accordion p-component')]//i[@class='pi pi-file']");
    public static By catalogTest = By.xpath("//div[contains(@class, 'p-accordion p-component')]//i[@class='pi pi-question-circle']");
    public static By answerArea = By.xpath("//textarea");
    public static By popupDiv = By.xpath("//div[text()='Content Completed Successfully']");
    public static By assignmentPopup = By.xpath("//div[text()='Assignment Completed Successfully']");

    public static By testList = By.xpath("//div//i[@class='pi pi-question-circle ng-star-inserted']");

    public static By downloadCertifcatebtn = By.xpath("//span[text()='Download Certificate']");
    public static By courseCatalogbtn = By.xpath("//span[text()='Course Catalog']");
    public static By courseDiv = By.xpath("//div[@class='p-card-body']");
    public static By testCount = By.xpath("(//div[@class='overlay-text-style'])[2]");
    public static By assignmentCount = By.xpath("(//div[@class='overlay-text-style'])[3]");
    public static By viewCourseBtn1 = By.xpath("(//span[text()='View Course'])[1]");
    public static By courseContent = By.xpath("//div[text()='Course Content']");
    public static By yesBtn = By.xpath("//span[text()='Yes']");
    public static By finishSubmit = By.xpath("//button//span[text()='Finish and Submit']");
    public static By downloadCertificate = By.xpath("//span[text()='Download Certificate']");
    public static By backtoCourse = By.xpath("//button//span[text()='Back To Course']");
    public static By proceedBtn = By.xpath("//span[text()='Proceed']");
    public static By courseCatagory = By.xpath("//div[@class='list-container']//div[@class='p-card p-component']//span[@class='category']");
    public static String courseCatagoryLable = "(//div[@class='list-container']//div[@class='p-card p-component']//span[@class='category'])[itr]";

    public static String vedioAndContent = "(//img[@class='ng-star-inserted'])[itr]";
    public static By vedio = By.xpath("//div[@class='video-parent-style ng-star-inserted']");
    public static By courseFilterdiv = By.xpath("//ul[contains(@class, 'p-dropdown-items ng-tns')]//li");
    public static By footerRightArrow = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
    public static By completedCourseCount = By.xpath("//div[@class='completed-courses-count']");
    public static By activeCourseCount = By.xpath("//div[@class='active-courses-count']");
    public static By totalCourseCount = By.xpath("//div[@class='total-courses-count']");
    public static By greenTick = By.xpath("//img[@class='tick-icon-style ng-star-inserted']");
    public static String courseArea = "(//div[@class='ml-1 mr-1'])[itr]//div[@class='rounded ml-4 mb-3 card-style ng-star-inserted']";
    public static String courseType = "(//ul[@class='p-tabview-nav']//li)[itr]";
    public static By completedCourseTab = By.xpath("//span[text()='Completed']");
    public static By threeDotIcon = By.xpath("(//span[@class='pi pi-ellipsis-v p-button-icon ng-star-inserted'])[2]");
    public static By viewandDownload = By.xpath("//label[text()='View/Download Certificate']");
    public static By viewandDownloadLable = By.xpath("//label[text()='This certification is awarded to']");
    public static By downloadBtn = By.xpath("//button[@class='p-button p-component p-button-icon-only p-ripple']");


}