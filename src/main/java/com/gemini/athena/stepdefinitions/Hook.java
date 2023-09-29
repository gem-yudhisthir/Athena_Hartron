package com.gemini.athena.stepdefinitions;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {
 //   static WebDriver driver;
    @Before
    public static void start() throws GemException {
        DriverManager.setUpBrowser();
    }
}

