package com.platform.project.commons;

import com.platform.project.pageObjects.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectManager
{
    private AndroidDriver<MobileElement> driver;
    private HomePage homePage;

    public PageObjectManager(AndroidDriver<MobileElement> driver)
    {
        this.driver = driver;
    }

    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
}
