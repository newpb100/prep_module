package com.ams.mod2.selenium.dto;

public class BorderParam {

    private String xpath;
    private String borderName;
    private String border;

    public BorderParam(String border, String borderName, String xpath){
        this.border = border;
        this.borderName = borderName;
        this.xpath = xpath;
    }

    public String getBorder() {
        return border;
    }

    public String getBorderName() {
        return borderName;
    }

    public String getXpath() {
        return xpath;
    }
}
