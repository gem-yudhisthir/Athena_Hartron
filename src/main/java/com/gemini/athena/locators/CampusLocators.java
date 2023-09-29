package com.gemini.athena.locators;

import org.openqa.selenium.By;

public class CampusLocators {

    public static By registeredCampus=By.xpath("//p-table//tbody/tr/td[1]");
    public static By actionsIcon=By.xpath("//span[contains(@class,'ellipsis')]//parent::button");
    public static By rowLength=By.xpath("//tbody/tr[1]/td");
}
