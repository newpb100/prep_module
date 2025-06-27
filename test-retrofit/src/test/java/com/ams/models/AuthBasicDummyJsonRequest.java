package com.ams.models;

public class AuthBasicDummyJsonRequest {
    public String username;
    public String password;

    public AuthBasicDummyJsonRequest(String username, String pass) {
        this.username = username;
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
