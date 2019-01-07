package com.example.demo.enums;

/**
 * @author tangyulin
 * @description
 * @createdate 11/01/2018
 */
public enum SkinColorEnum {
    HUANGZHOUREN("黄种人"),

    HEIZHONGREN("黑种人"),

    BAIZHONGREN("白种人")
    ;

    private String color;

    SkinColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
