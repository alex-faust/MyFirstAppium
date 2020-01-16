package com.platform.project.pageObjects;

import com.platform.project.commons.Commons;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    @FindBy(id = "at.markushi.reveal:id/btn_2")
    private WebElement button2;

    @FindBy(id = "at.markushi.reveal:id/title")
    private WebElement pageTitle;

    //using appium driver so you can pass ios or windows
    //AppiumDriver<MobileElement> driver;
    AndroidDriver<MobileElement> driver;
    private Logger log = Logger.getLogger(HomePage.class);

    public HomePage(AndroidDriver<MobileElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton2()
    {
        button2.click();
    }

    public String getPageTitle()
    {
        log.info("Getting title.");
        return Commons.getElementText(driver, pageTitle, 3);
        //return pageTitle.getText();
    }
}
