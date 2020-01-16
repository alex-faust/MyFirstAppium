package com.platform.project.commons;

public class TestContext
{
    private AppiumDriverManager appiumDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext()
    {
        appiumDriverManager = new AppiumDriverManager();
        pageObjectManager = new PageObjectManager(appiumDriverManager.getDriver());
    }

    public AppiumDriverManager getAppiumDriverManager()
    {
        return appiumDriverManager;
    }

    public PageObjectManager getPageObjectManager()
    {
        return pageObjectManager;
    }

}
