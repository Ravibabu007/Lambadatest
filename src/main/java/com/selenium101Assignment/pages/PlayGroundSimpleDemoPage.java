package com.selenium101Assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PlayGroundSimpleDemoPage {
    WebDriver driver;
    public PlayGroundSimpleDemoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[text()='Simple Form Demo']")
    WebElement simpleDemoEle;
    @FindBy(xpath = "//input[@id='user-message']") WebElement inputMessage;
    @FindBy(xpath = "//button[@id='showInput']") WebElement getCheckedValueButton;
    @FindBy(xpath = "//p[@id='message']") WebElement userEnteredMessage;
    public String simpleFormDemo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        simpleDemoEle.click();
        String simpleDemoLink=driver.getCurrentUrl();

       // System.out.println("Successfully Asserted Demo Link");
        return simpleDemoLink;
    }
    public String enteringMessageInTextBox(){

       String message="Hi this is Lambda Test Example";
        inputMessage.sendKeys(message);
        return message;
    }
    public String verifyingTextBox(){
        getCheckedValueButton.click();
        String userMessage= userEnteredMessage.getText();
        //System.out.println("Verified the TextBox");
        return userMessage;
    }
}
