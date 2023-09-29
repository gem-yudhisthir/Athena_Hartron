package com.gemini.athena.locators;

import org.openqa.selenium.By;

public class Course_Locators {
    public static By sidebar = By.xpath("//p-toolbar//em");
    public static By navbarDropdown = By.xpath("//button[@icon='pi pi-caret-down']");

    public static By profile = By.xpath("//span[text()='Profile']");
    public static By userName = By.xpath("//div[@class='upper-card-value']");
    public static By ownerName = By.xpath("//div[contains(@class,'p-multiselect-token')]//span");
    public static By treeList = By.xpath("//div[@class='p-steps p-component p-readonly']//ul//li");
    public static String tree = "(//div[@class='p-steps p-component p-readonly']//ul//li//span[@class='p-steps-title ng-star-inserted'])[itr]";
    public static By checkboxs = By.xpath("//div[@class='p-checkbox-box']");
    public static By courseInputFields = By.xpath("//form[@class='ng-untouched ng-pristine ng-invalid']//input");

    public static String option = "//li[@aria-label='input']";
    public static String dropdownIcon = "(//span[contains(@class,'chevron-down')]//parent::div)[itr]";
    public static By courseDescription = By.xpath("//textarea");
    public static By addContentTagInput = By.xpath("//input[@type='search']");
    public static String addContentTableRow = "(//div[@class='p-datatable-wrapper ng-star-inserted']//table)[1]//tr[itr]//td[1]";
    public static By addIcon = By.xpath("//i[contains(@class,'pi pi-plus')]");

    public static By addIconEdit = By.xpath("(//i[contains(@class,'pi pi-plus')])[2]");
    public static By deleteIcon = By.xpath("//i[contains(@class,'pi pi-trash')]");

    public static String popup = "//div[text()='input']";
    public static By addToCourseBtn = By.xpath("//span[text()='Add To Course']//parent::button");

    public static By addAssignmentBtn = By.xpath(" //button//span[text()='Add New Assignment']");

    public static String button = "//span[text()='input']//parent::button";
    public static By addToCourseDiv = By.xpath("//div[text()='No Records Found!!']");

    public static By courseSummaryDiv = By.xpath("//div[text()=' Move contents here to select the order! ']");

    public static By courseTypeDropdown = By.xpath(" (//span[contains(@class,'chevron-down')]//parent::div)[4]");
    public static By draftOrPublishDropdown = By.xpath(" (//span[contains(@class,'chevron-down')]//parent::div)[5]");

    public static String dropdownValue = "//span[text()='type']";

    public static By draftedCourse = By.xpath("//div[@class='name-style control-overflow longer-name']");

    public static By editIcon = By.xpath("//span[contains(@class,'pi pi-ellipsis')]");

    public static By editOption = By.xpath("//label[text()='Edit']");

    public static By publishButton = By.xpath("(//button//span[text()='Update Course & Publish'])[2]");

    public static By loadingIcon = By.xpath("//*[@class='p-progress-spinner-svg']");

    public static By courseNameInput = By.xpath("//input[@id='courseName']");
    public static By checkedAssignmentCheckbox = By.xpath("//span[contains(@class,'pi pi-check')]");
    public static By saveAsDraftButton = By.xpath("(//button//span[text()='Save As Draft'])[2]");

    public static String adminOption = "//label[text()='input']//parent::div";

    public static String userOption = "//span[text()='input']//parent::li";

    public static By nameFilterInput = By.xpath("//input[@placeholder='Name/Email']");

    public static By courseFilterInput = By.xpath("//input[@placeholder='Search Courses']");

    public static By userDropdown = By.xpath("//div[contains(@class,'p-dropdown-trigger')]//span");

    public static By courseFilterTagInput = By.xpath("//input[@placeholder='Search by Name/Tags']");

    public static By nameTagFilterInput = By.xpath("//input[@placeholder='Search by Name']");

    public static By contentsReport = By.xpath("//u[text()='Contents']");

    public static By assignmentReport = By.xpath("//u[text()='Assignments']");

    public static By contentStatus = By.xpath("(//div[@class='p-datatable-wrapper ng-star-inserted']//tr//td)[14]");

    public static By assignmentStatus = By.xpath("(//div[@class='p-datatable-wrapper ng-star-inserted']//tr//td)[24]");

    public static By reattemptLabel = By.xpath("//label[text()='Reattempt Course']");

}