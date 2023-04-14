package com.ams.mod2.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

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
