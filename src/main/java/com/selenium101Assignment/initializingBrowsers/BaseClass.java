package com.selenium101Assignment.initializingBrowsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseClass {
    public WebDriver driver;
    @BeforeSuite
    public void initializeBrowsers(){
        //WebDriverManager.chromiumdriver().setup();

    }
    @Parameters("browserName")
    @BeforeTest
    public void launchApp(String browserName) throws MalformedURLException {
        switch (browserName){
            case "chrome":
                /*WebDriverManager.chromiumdriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName("Windows 10");
            chromeOptions.setBrowserVersion("88.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "ravi18babu");
            ltOptions.put("accessKey", "s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho");
            ltOptions.put("project", "LambdaTest");
            ltOptions.put("selenium_version", "4.8.0");
            ltOptions.put("w3c", true);
            chromeOptions.setCapability("LT:Options", ltOptions);
            driver=new RemoteWebDriver(new URL("https://ravi18babu:s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho@hub.lambdatest.com/wd/hub"),chromeOptions);
            break;
            case "edge":
               /* WebDriverManager.chromiumdriver().setup();
                driver=new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName("macOS Sierra");
                edgeOptions.setBrowserVersion("87.0");
                HashMap<String, Object> ltOptions1 = new HashMap<String, Object>();
                ltOptions1.put("username", "ravi18babu");
                ltOptions1.put("accessKey", "s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho");
                ltOptions1.put("project", "LambdaTest");
                ltOptions1.put("w3c", true);
                edgeOptions.setCapability("LT:Options", ltOptions1);
                driver=new RemoteWebDriver(new URL("https://ravi18babu:s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho@hub.lambdatest.com/wd/hub"),edgeOptions);
                break;
            case "firefox":
                /*WebDriverManager.chromiumdriver().setup();
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName("Windows 7");
                firefoxOptions.setBrowserVersion("82.0");
                HashMap<String, Object> ltOptions2 = new HashMap<String, Object>();
                ltOptions2.put("username", "ravi18babu");
                ltOptions2.put("accessKey", "s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho");
                ltOptions2.put("project", "LambdaTest");
                ltOptions2.put("w3c", true);
                firefoxOptions.setCapability("LT:Options", ltOptions2);
                driver=new RemoteWebDriver(new URL("https://ravi18babu:s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho@hub.lambdatest.com/wd/hub"),firefoxOptions);
                break;
            case "internetExplorer":
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setPlatformName("Windows 10");
                internetExplorerOptions.setBrowserVersion("11.0");
                HashMap<String, Object> ltOptions3 = new HashMap<String, Object>();
                ltOptions3.put("username", "ravi18babu");
                ltOptions3.put("accessKey", "s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho");
                ltOptions3.put("project", "LambdaTest");
                ltOptions3.put("w3c", true);
                internetExplorerOptions.setCapability("LT:Options", ltOptions3);
                driver=new RemoteWebDriver(new URL("https://ravi18babu:s1lvLsVdcCosIfVJnoYT9DdoueiB41IWtYgFpg7hXUOjOJx1Ho@hub.lambdatest.com/wd/hub"),internetExplorerOptions);
                break;
        }

        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterTest
    public void killTheSession(){
        driver.quit();
    }

}
