package com.ams.mod2.selenium.appmanager;

import com.ams.mod2.selenium.tests.SpektrUser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationManager {
    WebDriver driver;
    boolean acceptNextAlert = true;
    JavascriptExecutor js;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void logout() throws InterruptedException {
        // open drop down user logout
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div[2]/div/div/span")).click();
        Thread.sleep(2000);
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C://Windows//system32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    public void openSettings(String field_name_rus) throws InterruptedException {
        int treeIndex = 0;
        // open settings
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/div/div/div[1]")).click();
        // open field
        switch (field_name_rus) {
            case "Валынтойское":
                treeIndex = 1;
                break;
            case "Воргенское":
                treeIndex = 2;
                break;
            default:
                treeIndex = 1;
        }

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/app-objects-tree/div/div[2]/itsk-tree/itsk-tree-host/itsk-tree-item[" + treeIndex + "]")).click();
        Thread.sleep(3000);
    }

    public void openProject(String monthAndYearRus) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ошибки'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Проекты'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + monthAndYearRus +"'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмена'])[1]/following::button[1]")).click();
    }

    public void login(SpektrUser spektrUser) {
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(spektrUser.getLogin());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(spektrUser.getPs());
        driver.findElement(By.id("kc-login")).click();
    }

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


}
