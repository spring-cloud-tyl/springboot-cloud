package com.example.demo;

/**
 * @author tangyulin
 * @description
 * @createdate 11/30/2018
 */
public class Test {


    @org.junit.Test
    public void test1() {
        String predicate = String.format("(%s)(?=(\\p{Lu}|\\P{InBASIC_LATIN}))", "tangYuLin");

        System.out.println(predicate);
    }

}
