package com.platform.project.steps;


import com.platform.project.commons.AppiumDriverManager;
import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePageSteps
{
    AppiumDriverManager appiumDriverManager;
    //AppiumDriver<MobileElement> driver;
    AndroidDriver<MobileElement> driver;
    HomePage homePage;
    TestContext testContext;

    public HomePageSteps(TestContext context)
    {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }
    /*@Before
    public void before()
    {
        appiumDriverManager = new AppiumDriverManager();
        driver = appiumDriverManager.getDriver();
        homePage = new HomePage(driver);
    }*/

    /*@After
    public void after()
    {
        appiumDriverManager.closeDriver();
    }*/

    @Then("^Click on the second button$")
    public void clickSecondButton2()
    {
        homePage.clickButton2();
    }

    @Then("^I verify that the page says (.*)$")
    public void verifyHomePage(String expectedTitle)
    {
        Commons.check(driver, homePage.getPageTitle().equals(expectedTitle),
                "Incorrect page opened.");
    }
}
