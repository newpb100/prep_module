package org.components;

import com.microsoft.playwright.Page;

public final class Header extends BaseComponent {

    // В отличие от Page-классов здесь нет степов т.к. компонент вспомогательный

    public Header(final Page page) {
        super(page);
    }

    public void clickOnHamburgerIcon() {
        page.click("#react-burger-menu-btn");
    }

    public void clickOnCart(){
        page.locator("//a[@data-test='shopping-cart-link']").click();
    }
}