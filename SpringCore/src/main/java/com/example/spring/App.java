package com.example.spring;

import com.example.SpringCoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //helloclazz
        HelloClazz helloClazz1 = (HelloClazz) context.getBean("helloJavaClazz");
        helloClazz1.printMessage();
        HelloClazz helloClazz2 = (HelloClazz) context.getBean("helloJavaClazz");
        helloClazz2.printMessage();
        System.out.println(helloClazz1==helloClazz2);
        context.registerShutdownHook();
        //helloworld
        HelloWorld helloWorld1= (HelloWorld) context.getBean("helloWorld");
        helloWorld1.sayHello();
        //clazzjava
        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        System.out.println("- Map implement is "+clazz.getStudents().getClass());
        System.out.println("- There are "+clazz.getStudents().size()+" in the class");

        context.start();
        context.stop();
    }
}
