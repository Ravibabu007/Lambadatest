package com.selenium101Assignment;

import com.selenium101Assignment.initializingBrowsers.BaseClass;
import com.selenium101Assignment.pages.DragDropSlidersPage;
import com.selenium101Assignment.pages.InputFormsPage;
import com.selenium101Assignment.pages.PlayGroundSimpleDemoPage;
import com.selenium101Assignment.pages.SuccessMessagePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public class TestClassForPlayGround extends BaseClass {
    public PlayGroundSimpleDemoPage playGroundSimpleDemoPage;
    public DragDropSlidersPage dragDropSlidersPage;
    public InputFormsPage inputFormsPage;
    public SuccessMessagePage successMessagePage;
    @BeforeTest
    public void initializePages(){
        playGroundSimpleDemoPage =new PlayGroundSimpleDemoPage(driver);
        dragDropSlidersPage=new DragDropSlidersPage(driver);
        inputFormsPage=new InputFormsPage(driver);
        successMessagePage=new SuccessMessagePage(driver);
    }
    @Test
    public void verifySimpleFormDemo(){
        //playGroundSimpleDemoPage.simpleFormDemo();
        Assert.assertTrue(playGroundSimpleDemoPage.simpleFormDemo().contains("simple-form-demo"));
       Assert.assertEquals(playGroundSimpleDemoPage.enteringMessageInTextBox(), playGroundSimpleDemoPage.verifyingTextBox());
    }
    @Test(priority =1)
    public void verifyDragDrop(){
        dragDropSlidersPage.dragDropSlider();
    }
    @Test(priority = 2)
    public void verifyTheNameField(){

      String validationMessage= inputFormsPage.theAlertPopUp();
       ArrayList errorMessages=new ArrayList<>();
        errorMessages.add("Please fill out this field.");
        errorMessages.add("This is a required field");
       //Assert.assertEquals(validationMessage,"Please fill out this field.");
        Assert.assertTrue(errorMessages.contains(validationMessage));
        inputFormsPage.enteringDataInForm();
        String message=successMessagePage.verifyThankYouMessage();
        Assert.assertEquals(message,"Thanks for contacting us, we will get back to you shortly.");
    }
}
