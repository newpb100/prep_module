package com.ams.mod2.selenium.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewBorderParamsTest extends TestBase {

    @Test
    void viewBorderParamsTest() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Воргенское");
        app.getSettingsHelper().openSectionDostrely();
        app.getSessionHelper().logout();
    }

    @Test
    void viewOptions() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Валынтойское");
        app.getSettingsHelper().moveToOptions();
        app.getSettingsHelper().openOptionsDostrely();
        app.getSessionHelper().logout();
    }


}

