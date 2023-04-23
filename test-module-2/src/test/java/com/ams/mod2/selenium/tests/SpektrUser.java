package com.ams.mod2.selenium.tests;

public class SpektrUser {
    private final String login;
    private final String ps;

    public SpektrUser() {
        this.login = ConfProperties.getProperty("logn");
        this.ps = ConfProperties.getProperty("pwd");
    }

    public String getLogin() {
        return login;
    }

    public String getPs() {
        return ps;
    }
}
