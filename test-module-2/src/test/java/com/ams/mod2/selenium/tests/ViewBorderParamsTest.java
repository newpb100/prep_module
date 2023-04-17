package com.ams.mod2.selenium.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewBorderParamsTest extends TestBase {


    @Test
    void viewBorderParamsTest() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettings("Воргенское");
        app.openSection();
        app.getSessionHelper().logout();
    }


}

