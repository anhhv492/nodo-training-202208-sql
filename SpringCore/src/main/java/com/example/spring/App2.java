package com.example.spring;

import com.example.SpringCoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        HelloClazz myBean = (HelloClazz) ctx.getBean("bean2");
        System.out.println(myBean.message);
    }
}
