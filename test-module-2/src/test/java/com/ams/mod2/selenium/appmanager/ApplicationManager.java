package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationManager {
    private SessionHelper sessionHelper;
    private SettingsHelper settingsHelper;

    WebDriver driver;

    boolean acceptNextAlert = true;
    JavascriptExecutor js;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C://Windows//system32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        settingsHelper = new SettingsHelper(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    // is it need to be relocated into separate Helper?
    // if it will be done , methods isElementPresent, isAlertPresent, closeAlertAndGetItsText also need to be relocated
    public void openSection() throws InterruptedException {
        // open section
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[7]/div/div/itsk-grid-expand")).click();
        Thread.sleep(2000);
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
