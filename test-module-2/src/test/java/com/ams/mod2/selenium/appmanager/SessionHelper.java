package com.ams.mod2.selenium.appmanager;

import com.ams.mod2.selenium.tests.SpektrUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {

    private WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(SpektrUser spektrUser) {
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(spektrUser.getLogin());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(spektrUser.getPs());
        driver.findElement(By.id("kc-login")).click();
    }

    public void logout() throws InterruptedException {
        // open drop down user logout
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div[2]/div/div/span")).click();
        Thread.sleep(2000);
    }
}
