package com.example.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitSampleBean implements BeanPostProcessor {
    public InitSampleBean(HelloClazz helloClazz) {
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before Initialization : "+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after Initialization : "+beanName);
        return bean;
    }
}
