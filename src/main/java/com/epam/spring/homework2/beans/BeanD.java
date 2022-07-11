package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.Valid;

public class BeanD extends DefaultBean implements Valid {

    public BeanD(String name, int value) {
        super(name, value);
    }

    public void myInitMethod() {
        System.out.println("In this bean is used " + name + " initMethod");
    }

    public void myDestroyMethod() {
        System.out.println("In this bean is used " + name + " destroyMethod");
    }
}
