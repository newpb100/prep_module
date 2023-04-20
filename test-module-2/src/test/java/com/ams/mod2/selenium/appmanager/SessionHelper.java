package com.ams.mod2.selenium.appmanager;

import com.ams.mod2.selenium.tests.SpektrUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(SpektrUser spektrUser) {
        driver.get("http://spektr-frontend-spektr-test.apps.okd.cloud.nedra.digital/home");
        type("username", spektrUser.getLogin());
        type("password", spektrUser.getPs());
        driver.findElement(By.id("kc-login")).click();
    }

    public void logout() throws InterruptedException {
        // open drop down user logout
        click("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div/div/div/div[1]");
        Thread.sleep(2000);
        click("/html/body/app-root/div/app-extraction-project-outlet/app-header/div/div[2]/itsk-dropdown/div[2]/div/div/span");
        Thread.sleep(2000);
    }
}
