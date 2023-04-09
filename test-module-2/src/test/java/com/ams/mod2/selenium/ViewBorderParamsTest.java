package com.ams.mod2.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewBorderParamsTest extends TestBase {


    @Test
    void viewBorderParamsTest() throws InterruptedException {
        login(new SpektrUser());
        openProject("Февраль 2023");
        openSettings("Воргенское");
        openSection();
        logout();
    }

    private void openSection() throws InterruptedException {
        // open section
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[7]/div/div/itsk-grid-expand")).click();
        Thread.sleep(2000);
    }


}

