package org.pages;

import com.microsoft.playwright.Page;

import static org.config.ConfigurationManager.config;


abstract public class BasePage {


    protected Page page;

    public void setAndConfigurePage(final Page page) {
        this.page = page;
        page.setDefaultTimeout(config().timeout());
    }

    public void initComponents() {}

}
