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

        //just a sample of hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    System.out.println("inside addShutdownHook step 1");
                    System.out.println("inside addShutdownHook step 2");
                })
        );
    }

   @BeforeEach
    public void doSuite(){
        System.out.println("inside beforeEach-method");
        if (suite == null){
            suite = "== suite field, that initialized as a singleton, class : " + this.getClass().getName();
        }else{
            System.out.println(suite);
        }
    }

    @AfterAll
    public static void tearDown() throws Exception {
        //public void tearDown() throws Exception {
        app.stop();
        System.out.println();
        System.out.println("tearDown");
    }

}
