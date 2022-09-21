package com.example.spring;

import org.springframework.web.context.ContextLoaderListener;

public class AppContextLoaderListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent event) {
        System.out.println("---> Create application");
    }

    @Override
    public void contextDestroyed(javax.servlet.ServletContextEvent event) {
        System.out.println("---> Close application");
    }
}
