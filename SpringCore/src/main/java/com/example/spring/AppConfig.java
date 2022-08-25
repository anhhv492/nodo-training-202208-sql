package com.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name="bean2")
    @Scope("singleton")
    public HelloClazz getHelloBean(){
        HelloClazz bean = new HelloClazz();
        bean.message = "xin chao viet anh";
        return bean;
    }
}
