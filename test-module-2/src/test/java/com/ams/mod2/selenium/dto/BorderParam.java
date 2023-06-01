package com.ams.mod2.selenium.dto;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "BorderParam{" +
                "borderName='" + borderName + '\'' +
                ", border='" + border + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorderParam that = (BorderParam) o;
        return borderName.equals(that.borderName) && Objects.equals(border, that.border);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borderName, border);
    }
}
