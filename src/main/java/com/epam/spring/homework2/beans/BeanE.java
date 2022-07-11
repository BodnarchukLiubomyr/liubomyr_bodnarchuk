package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.Valid;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE extends DefaultBean implements Valid {

    public BeanE(String name, int value) {
        super(name, value);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("In this bean is used " + name + " PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("In this bean is used " + name + " PreDestroy method");
    }
}
