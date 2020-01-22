package com.bridgelabz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass implements IAutoConstant{

    public static WebDriver driver;

    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName) {

        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty(CHROMEKEY,CHROMEVALUE);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FIREFOXKEY,FIREFOXVALUE);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

