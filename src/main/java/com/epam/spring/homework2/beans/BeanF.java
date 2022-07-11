package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.Valid;

public class BeanF extends DefaultBean implements Valid {

    public BeanF(String name, int value) {
        super(name, value);
    }
}
