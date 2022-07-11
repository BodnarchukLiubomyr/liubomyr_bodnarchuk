package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.Valid;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA extends DefaultBean implements Valid, DisposableBean, InitializingBean {

    public BeanA(String name, int value) {
        super(name, value);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + "-> DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + "-> InitializingBean");
    }
}
