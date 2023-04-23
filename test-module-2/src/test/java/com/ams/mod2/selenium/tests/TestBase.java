package com.ams.mod2.selenium.tests;

import com.ams.mod2.selenium.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeAll
    public void setUp() throws Exception {
        app.init();
    }

    @AfterAll
    public void tearDown() throws Exception {
        app.stop();
    }

}
