package com.gemini.athena.locators;

import org.openqa.selenium.By;

public class QuestionsLocators {

    public static String dropdownValue="//p-dropdownitem[contains(@ng-reflect-label,'input')]";
    public static By dropdownFields=By.xpath("//form[@fxlayout='column wrap']//p-dropdown");
    public static By marksField=By.xpath("//input[@placeholder='Marks']");

    public static By questionBox=By.xpath("//div[@data-gramm='false']");
    public static By optionsBox=By.xpath("//div[@class='editorDiv']//div[@data-gramm='false']");
    public static By selectOption=By.xpath("//div[@class='p-scrollpanel-wrapper']//div[@class='p-checkbox-box']");
    public static By firstColumn=By.xpath("//tbody/tr/td[1]");
    public static By addButton=By.xpath("//button[@ng-reflect-label='Add']");
}
