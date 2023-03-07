package com.selenium101Assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessMessagePage {
    WebDriver driver;
    public SuccessMessagePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//form[@id='seleniumform']//following-sibling::p")
    WebElement successMessageElement;
    public String verifyThankYouMessage(){
        String successMessage=successMessageElement.getText();
        return successMessage;
    }
}
