package com.example.jdbc;

import com.example.SpringCoreApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

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
            int idUpdate=3;
            int ageUpdate=45;
            jdbc.updateAgeById(idUpdate,ageUpdate);
            System.out.println("- Update id: "+idUpdate+" age: "+ageUpdate+" success!");
            int idDelete=2;
            jdbc.deleteAgeById(idDelete);
            System.out.println("- Delete id: "+idDelete+" success!");

//            List<Student> students = new ArrayList<>();
//            students.add(new Student(4,"Hải Bốn Rưỡi",10));
//            students.add(new Student(5,"Tiến Bờ Rai",50));
//            students.add(new Student(6,"Hạ Việt Anh",20));
//            int[] values = jdbc.add(students);
//            for (int i=0;i<values.length;i++){
//                LOGGER.info("- Add record "+i+": "+(values[i]==0?"failse!":"success!"));
//            }
//            jdbc.loadStudent("a").forEach(student -> {
//                LOGGER.info(student);
//            });
            jdbc.save(8,"dragon ball super",41);
            jdbc.loadAllStudent().forEach(student -> {
                LOGGER.info(student);
            });
            LOGGER.info("- Total va_students is = "+jdbc.totalRecord());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
