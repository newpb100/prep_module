package com.ams.mod2.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewBorderParamsTest extends TestBase {


    @Test
    void viewBorderParamsTest() throws InterruptedException {
        app.login(new SpektrUser());
        app.openProject("Февраль 2023");
        app.openSettings("Воргенское");
        app.openSection();
        app.logout();
    }


}

