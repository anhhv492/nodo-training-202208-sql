package com.example.jdbc;

import com.example.SpringCoreApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApp {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    public static void main(String[] args) {
        try{
            ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
            StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
            LOGGER.info("- Created bean "+jdbc);
            //insert
//            jdbc.insert(0,"ha viet anh",20);
//            jdbc.insert(1,"le van luyen",30);
//            jdbc.insert(2,"viet anh ha",12);
//            jdbc.insert(3,"viet anh ha",12);
            LOGGER.info("- Total va_students is = "+jdbc.totalRecord());

            jdbc.loadStudent("a").forEach(student -> {
                LOGGER.info(student);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
