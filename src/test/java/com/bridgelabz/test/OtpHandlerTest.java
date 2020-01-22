package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.model.OTPHandler;
import org.testng.annotations.Test;

public class OtpHandlerTest extends BaseClass {

    @Test
    public void handleOTP() throws InterruptedException {

        OTPHandler handle = new OTPHandler(driver);
        driver.get("https://www.amazon.in");
        Thread.sleep(2000);
        handle.clickOnArrow(driver);
        Thread.sleep(2000);
        handle.clickOnStartHere();
        Thread.sleep(2000);
        handle.setName("Pallavi");
        Thread.sleep(2000);
        handle.selectCode();
        Thread.sleep(2000);
        handle.setStateCode();
        Thread.sleep(2000);
        handle.setPhoneNumber("2055093729");
        handle.setPassword("Psraut@123");
        handle.clickOnContinueBtn();
        Thread.sleep(2000);
        handle.getOTP();

    }
}
