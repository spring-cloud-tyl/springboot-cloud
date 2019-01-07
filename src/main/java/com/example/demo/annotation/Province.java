package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author tangyulin
 * @description
 * @createdate 11/01/2018
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Province {

    String name();

    String code();
}
