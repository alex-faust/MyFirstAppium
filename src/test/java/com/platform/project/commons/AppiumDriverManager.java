package com.platform.project.commons;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumDriverManager
{
    private AndroidDriver<MobileElement> driver;
    //to make it universal for android and ios, use AppiumDriver instead of AndroidDriver
    private Logger log = Logger.getLogger(AppiumDriverManager.class);

    //create a parameter so you can pass which device you want to use, ios or android
    private AndroidDriver<MobileElement> createDriver()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 27");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\abcle\\OneDrive\\Desktop\\example.apk");

        //connect to appium server
        try
        {
            //the /wd/hub is the remote path in the appium menu under custom server
            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<>(url, caps);
            return driver;
        } catch (MalformedURLException mue) {
            log.info("Unable to connect to Appium server");
            mue.printStackTrace();
            return null;
        }
    }

    public AndroidDriver<MobileElement> getDriver()
    {
        if (driver == null)
        {
            try
            {
                driver = createDriver();
                log.info("Driver initialization successful.");
            } catch (Exception e)
            {
                log.info("Driver initialization failed.");
                e.printStackTrace();
            }
        } else
        {
            log.info("Driver already exists.");
        }
        return driver;
    }

    public void closeDriver()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

}
