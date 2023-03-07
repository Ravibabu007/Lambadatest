package com.selenium101Assignment.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class InputFormsPage {
    WebDriver driver;
    public InputFormsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//p[text()='Input Forms']")
    WebElement inputFormsOptions;

    @FindBy(xpath = "//button[text()='Submit']") WebElement submitButton;
    @FindBy(xpath = "//input[@id='name']") WebElement nameInput;
    @FindBy(xpath = "//input[@id='inputEmail4']") WebElement emailInput;
    @FindBy(xpath = "//input[@id='inputPassword4']") WebElement passwordInput;
    @FindBy(xpath = "//input[@id='company']") WebElement companyNameInput;
    @FindBy(xpath = "//input[@id='websitename']") WebElement websiteNameInput;
    @FindBy(xpath = "//input[@id='inputCity']") WebElement inputCityName;
    @FindBy(xpath = "//input[@id='inputAddress1']") WebElement inputAddressLine1;
    @FindBy(xpath = "//input[@id='inputAddress2']") WebElement inputAddressLine2;
    @FindBy(xpath = "//input[@id='inputState']") WebElement inputState;
    @FindBy(xpath = "//input[@id='inputZip']") WebElement inputZip;
    @FindBy(xpath = "//a[text()='Input Form Submit']") WebElement inputFormSubmit;
    @FindBy(xpath = "//select[@name='country']") WebElement selectCountry;
    @FindBy(xpath = "//span[@id='exit_popup_close']") WebElement popUp;
    public String theAlertPopUp(){
        inputFormsOptions.click();
        inputFormSubmit.click();
        submitButton.click();
       String validationMessage= nameInput.getAttribute("validationMessage");
      /* String actualMessage="Please fill out this field.";
        Assert.assertEquals(validationMessage,actualMessage);*/
        return validationMessage;

    }
    public void enteringDataInForm(){
        nameInput.sendKeys("RaviBabu");
        emailInput.sendKeys("ravi18babu@gmail.com");
        passwordInput.sendKeys("ravibabu@123");
        companyNameInput.sendKeys("Rcompany");
        websiteNameInput.sendKeys("www.rcompany.com");
       Select select=new Select(selectCountry);
       select.selectByVisibleText("United States");
        inputCityName.sendKeys("Dallas");
        inputAddressLine1.sendKeys("Capital ove");
        inputAddressLine2.sendKeys("4thLane");
        inputState.sendKeys("Texas");
        inputZip.sendKeys("75204");
       /* WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(popUp));*/
        Actions actions=new Actions(driver);
        try {
        actions.click(popUp).build().perform();}
        catch (Exception e){
            System.out.println(e.toString());
        }
        submitButton.click();
    }
}
