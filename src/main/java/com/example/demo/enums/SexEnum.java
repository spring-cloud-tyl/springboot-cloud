package com.example.demo.enums;

/**
 * @author tangyulin
 * @description
 * @createdate 10/31/2018
 */
public enum SexEnum {

    /**
     * 女
     */
    FEMALE(2,"女"),

    /**
     * 男
     */
    MALE(1,"男");


    private int code;
    private String desc;

    SexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
