package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

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
}
