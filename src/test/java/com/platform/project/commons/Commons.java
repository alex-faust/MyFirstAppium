package com.platform.project.commons;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.currentThread;

public class Commons
{
    private static Logger log = Logger.getLogger(Commons.class);

    private static void takeSnapShot(AndroidDriver driver, String javaClass, String methodName)
    {
        String timeStamp = new SimpleDateFormat("yy-MM-dd_HH.mm.ss_").format(new Date());
        String fileName = timeStamp + javaClass + "_" + methodName + ".png";
        log.info(fileName);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtil.copyFile(srcFile, new File("./screenshots/" + fileName));
            log.info("Screenshot " + fileName + " taken.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            log.info("Unable to take screenshot " + fileName);
        }
    }

    public static void check(AndroidDriver<MobileElement> driver, boolean condition, String failMessage)
    {
        if (condition)
        {
            log.info("Check condition is true.");
            Assert.assertTrue(true);
        } else {
            log.info(failMessage);
            takeSnapShot(driver, currentThread().getStackTrace()[2].getClassName(),
                    currentThread().getStackTrace()[2].getMethodName());
            Assert.fail();
        }
    }

    public static boolean waitForeElement(AndroidDriver<MobileElement> driver, WebElement element, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info(element.getText() + " is visible.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Element is not visible.");
            return false;
        }
    }

    public static String getElementText(AndroidDriver driver, WebElement element, int seconds)
    {
        if (waitForeElement(driver, element, seconds))
        {
            String elementText = element.getText();
            log.info("Element text is: " + elementText);
            return elementText;
        } else {
            return "";
        }
    }

    public static void clickOnElement(AndroidDriver driver, MobileElement element, int seconds)
    {
        if (waitForeElement(driver, element, seconds))
        {
            log.info("Clicking on element.");
            element.click();
        } else {
            log.info("Element could not be found.");
        }
    }
}
