package org.components;

import com.microsoft.playwright.Page;

abstract public class BaseComponent {

    protected Page page;

    protected BaseComponent(final Page page) {
        this.page = page;
    }
}