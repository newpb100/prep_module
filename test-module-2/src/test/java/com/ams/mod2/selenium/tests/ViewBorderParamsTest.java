package com.ams.mod2.selenium.tests;

import com.ams.mod2.selenium.dto.SpektrUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ViewBorderParamsTest extends TestBase {

    @Test
    void viewBorderParams() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        //app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openProject("Май 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Воргенское");
        app.getSettingsHelper().openSectionDostrely();
        app.getSettingsHelper().checkBorderParamsList();
        app.getSettingsHelper().compareBorderParamsList();        // for educational purposes, no business value
        app.getSessionHelper().logout();
        //System.out.println("this = " + this);
    }

    @Test
    void checkNavigationLinks() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Май 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Воргенское");
        app.getSettingsHelper().compareListsAfterChanges();                   // for educational purposes, no business value
        //app.getSettingsHelper().checkNavigationLinks();         // for educational purposes, no business value
        app.getSessionHelper().logout();
        //System.out.println("this = " + this);
    }


    @Test
    void viewOptions() throws InterruptedException {
        app.getSessionHelper().login(new SpektrUser());
        app.getSettingsHelper().openProject("Февраль 2023");
        app.getSettingsHelper().openSettingsOfFieldByName("Валынтойское");
        app.getSettingsHelper().moveToOptions();
        // check how works ShutdownHook
        //System.exit(0);
        app.getSettingsHelper().openOptionsDostrely();
        app.getSessionHelper().logout();
        System.out.println("this = " + this);
    }

    @Test
    void doMock1(){
        System.out.println("doMock1 , this = " + this + " , class : " + this.getClass().getName());
    }

    @Test
    void doMock2(){
        System.out.println("doMock2, this = " + this + " , class : " + this.getClass().getName());
    }



}

