package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.Valid;

public class BeanB extends DefaultBean implements Valid {

    public BeanB(String name, int value) {
        super(name, value);
    }

    public void myInitMethod() {
        System.out.println("In this bean is used " + name + " MyInitMethod");
    }

    public void myNewInitMethod() {
        System.out.println("In this bean is used " + name + " MyNewInitMethod");
    }

    public void myDestroyMethod() {
        System.out.println("In this bean is used " + name + " MyDestroyMethod");
    }
}
