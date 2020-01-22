package com.bridgelabz.model;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OTPHandler {
    public static final String ACCOUNT_SID="AC16534530ee543e7c2ac9597e9d8aecf5";
    public static final String AUTH_TOKEN="fe63b7588f02c24fe432c541520e70d4";

    @FindBy(xpath = "//a[@id='nav-link-accountList']//span[@class='nav-icon nav-arrow']")
    WebElement arrow;

    @FindBy(linkText = "Start here.")
    WebElement startHere;

    @FindBy(id = "ap_customer_name")
    WebElement userName;

    @FindBy(id = "ap_phone_number")
    WebElement phoneNumber;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    WebElement stdCode;

    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueBtn;

    @FindBy(id = "auth-country-picker_212")
    WebElement stateCode;

    public OTPHandler(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickOnArrow(WebDriver driver)
    {
        arrow.click();
    }

    public void clickOnStartHere()
    {
        startHere.click();
    }

    public void setName(String name)
    {
        userName.sendKeys(name);
    }

    public void setPhoneNumber(String number)
    {
        phoneNumber.sendKeys(number);
    }

    public void selectCode()
    {
        stdCode.click();
    }

    public void setStateCode()
    {
        stateCode.click();
    }

    public void setPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clickOnContinueBtn()
    {
        continueBtn.click();
    }

    public static String getMessage()
    {
        return getMessages().filter(m->m.getDirection().compareTo(Message.Direction.INBOUND)==0)
                .filter(m->m.getTo().equals("+12055093729")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages()
    {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(),false);
    }
    public void getOTP()
    {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        String sms = getMessage();
        System.out.println(sms);
    }
}
