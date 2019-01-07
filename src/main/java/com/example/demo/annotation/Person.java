package com.example.demo.annotation;

import com.example.demo.enums.SkinColorEnum;

import java.lang.annotation.*;

/**
 * @author tangyulin
 * @description
 * @createdate 10/31/2018
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Person {

    String name();

    SkinColorEnum skinColor() default SkinColorEnum.HUANGZHOUREN;

    int age();
}
