package com.example;

import com.example.spring.HelloClazz;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
    }

}
