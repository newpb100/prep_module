package com.ams.mod2.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewBorderParamsTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;


    @BeforeAll
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://Windows//system32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }


    @Test
    void viewBorderParamsTest() throws InterruptedException {
        System.out.println("Test Module 2, ViewBorderParamsTest class, inside the package " + this);

        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home");
        driver.get("https://keycloak-spektr-keycloak.apps.okd.cloud.nedra.digital/auth/realms/spektr-frontend/protocol/openid-connect/auth?response_type=code&client_id=frontend-web&state=Tn4wVlFaaVlaLmVtQnEzM3h4aWtHTVcwc2pjYmgzbHJ6Y0p1M0tkcm4ycmdV&redirect_uri=http%3A%2F%2Fspektr-frontend-spektr-test.apps.okd.cloud.nedra.digital%2Fhome&scope=openid%20profile%20email%20roles&code_challenge=Gafv5Rj85eDBlmq3opemvTMVxMN12DxxAfrxh0XjJQg&code_challenge_method=S256&nonce=Tn4wVlFaaVlaLmVtQnEzM3h4aWtHTVcwc2pjYmgzbHJ6Y0p1M0tkcm4ycmdV");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("testspektr");
        driver.findElement(By.id("password")).clear();
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home?state=Tn4wVlFaaVlaLmVtQnEzM3h4aWtHTVcwc2pjYmgzbHJ6Y0p1M0tkcm4ycmdV&code=c0879c8c-a47e-403f-a4dd-772b54e07e39.fdacf154-47e5-47ac-8e96-71cf7889e673.4b738cb8-bd31-4209-b409-3bf3f2d56ba7");
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ошибки'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Проекты'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Февраль 2023'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмена'])[1]/following::button[1]")).click();
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/extraction/f6b51fa1-e998-48b6-89a7-36a75b77b27e/graphics?orgId=6&fieldId=all&month=2&year=2023");
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/div/div/div[1]")).click();
        // open valyntoyskoe
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/app-objects-tree/div/div[2]/itsk-tree/itsk-tree-host/itsk-tree-item[1]")).click();
        // open dostrely
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[7]/div/div/itsk-grid-expand")).click();
        // open drop down user
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div/div/div/div[1]")).click();
        //log out
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div[2]/div/div/span")).click();
        Thread.sleep(2000);
    }

    @AfterAll
    public void tearDown() throws Exception {
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

