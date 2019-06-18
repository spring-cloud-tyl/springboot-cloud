package com.example.demo.test;

import com.example.demo.annotation.Person;
import com.example.demo.annotation.Province;


/**
 * @author tangyulin
 * @description
 * @createdate 11/01/2018
 */
public class AnnotaionTest {

    public static void main(String[] args) {
        Class<Chinese> chineseClass = Chinese.class;
        Person person = chineseClass.getAnnotation(Person.class);
        System.out.println(person.name() + "---" + person.skinColor() + "---" + person.age() + "\n");

        Class<ShangHai> shangHaiClass = ShangHai.class;
        Province province = shangHaiClass.getAnnotation(Province.class);
        System.out.println(province.name() + "----" + province.code());
    }
}
