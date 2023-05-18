package com.ams.mod2.selenium.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ViewBorderParamsTest extends TestBase {

    @Test
    void viewBorderParamsTest() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Воргенское");
        app.getSettingsHelper().openSectionDostrely();
        app.getSessionHelper().logout();
        System.out.println("this = " + this);
    }

    @Test
    void viewOptions() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Валынтойское");
        app.getSettingsHelper().moveToOptions();
        app.getSettingsHelper().openOptionsDostrely();
        app.getSessionHelper().logout();
        System.out.println("this = " + this);
    }

    @Test
    void mockTest1(){
        System.out.println("mockTest 1 , this = " + this);
    }

    @Test
    void mockTest2(){
        System.out.println("mockTest 2, this = " + this);
    }



}

