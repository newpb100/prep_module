package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationManager {
    private SessionHelper sessionHelper;
    private SettingsHelper settingsHelper;

    WebDriver driver;
    String browserType;

    boolean acceptNextAlert = true;
    JavascriptExecutor js;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        if  (browserType.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        }else if (browserType.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        }else if (browserType.equals(BrowserType.EDGE)) {
            System.setProperty("webdriver.edge.driver", "C://work//bin//drivers//msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        settingsHelper = new SettingsHelper(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


    public SettingsHelper getSettingsHelper() {
        return settingsHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
