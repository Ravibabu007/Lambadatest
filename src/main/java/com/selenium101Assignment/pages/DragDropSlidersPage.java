package com.selenium101Assignment.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DragDropSlidersPage {
    WebDriver driver;
    public DragDropSlidersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    WebElement dragDropOption;
    @FindBy(xpath = "//p[text()='Progress Bar & Sliders']") WebElement progressBarAndSlider;
    @FindBy(xpath = "//div[@id='slider3']//descendant::input") WebElement dragDropElement;
    public void dragDropSlider(){
        progressBarAndSlider.click();
        dragDropOption.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*Actions move=new Actions(driver);
        Action action=(Action)move.dragAndDropBy(dragDropElement,95,0).build();
        ((Action)action).perform();*/
        for(int range=15;range<95;range++){
            dragDropElement.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
