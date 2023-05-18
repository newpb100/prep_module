package com.ams.mod2.selenium.tests;

import com.ams.mod2.selenium.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {
    protected final static ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    //ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    //protected final ApplicationManager app = new ApplicationManager(BrowserType.EDGE);

    protected static String suite;

    @BeforeAll
    public static void setUp() throws Exception {
    //public void setUp() throws Exception {

        app.init();
        System.out.println("setUp");
    }

    @AfterAll
    public static void tearDown() throws Exception {
    //public void tearDown() throws Exception {
        app.stop();
        System.out.println("tearDown");
    }

    @BeforeEach
    public void doSuite(){
        if (suite == null){
            suite = "=== field that initialized as a singleton === " + this;
        }else{
            System.out.println(suite);
        }
    }

}
