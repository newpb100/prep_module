package org.tests;

import org.pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void testCorrectLoginCredentials() {
        ProductsPage productsPage = loginPage.loginAs("standard_user", "secret_sauce");
        assertThat(productsPage.getTitle()).hasText("Products");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.loginAs("wrong", "fake");
        assertThat(loginPage.getErrorMessage())
                .hasText("1Epic sadface: Username and password do not match any user in this service");
    }
}