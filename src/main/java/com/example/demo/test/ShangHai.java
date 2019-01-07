package com.example.demo.test;

import com.example.demo.annotation.Province;

/**
 * @author tangyulin
 * @description
 * @createdate 11/01/2018
 */
@Province(name = "上海",code = "001")
public class ShangHai {

    private String address;

    private String feature;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
