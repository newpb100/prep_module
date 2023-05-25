package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
    protected WebDriver driver;

    boolean acceptNextAlert = true;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(String s) {
        driver.findElement(By.xpath(s)).click();
    }

    protected void type(String username, String login) {
        driver.findElement(By.id(username)).clear();
        driver.findElement(By.id(username)).sendKeys(login);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
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

}
