package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.epam.spring.homework2.beans")
public class BeanConfig {
    @Value("beanA")
    private String beanAName;
    @Value("1")
    private int beanAValue;

    @Value("${beanB.name}")
    private String beanBName;
    @Value("${beanB.value}")
    private int beanBValue;

    @Value("${beanC.name}")
    private String beanCName;
    @Value("${beanC.value}")
    private int beanCValue;

    @Value("${beanD.name}")
    private String beanDName;
    @Value("${beanD.value}")
    private int beanDValue;

    @Value("beanE")
    private String beanEName;
    @Value("5")
    private int beanEValue;

    @Value("beanF")
    private String beanFName;
    @Value("6")
    private int beanFValue;


    @Bean
    public BeanA beanA() {
        return new BeanA(beanAName,beanAValue);
    }

    @DependsOn({"beanD"})
    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanB beanB() {
        return new BeanB(beanBName, beanBValue);
    }

    @DependsOn({"beanB"})
    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanC beanC() {
        return new BeanC(beanCName, beanCValue);
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    public BeanD beanD() {
        return new BeanD(beanDName, beanDValue);
    }

    @Bean
    public BeanE beanE() {
        return new BeanE(beanEName, beanEValue);
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF(beanFName, beanFValue);
    }
}
