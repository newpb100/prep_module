package com.ams.mod2.selenium.tests;

import com.ams.mod2.selenium.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {
    //protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    //protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    protected final ApplicationManager app = new ApplicationManager(BrowserType.EDGE);

    @BeforeAll
    public void setUp() throws Exception {
        app.init();
    }

    @AfterAll
    public void tearDown() throws Exception {
        app.stop();
    }

}
