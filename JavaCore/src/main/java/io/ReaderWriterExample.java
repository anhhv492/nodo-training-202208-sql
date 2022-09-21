package io;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\temp\\test2\\io_sample.txt");
        try (FileWriter writer = new FileWriter(file)){
            writer.write("\r\n");
            writer.write("Ha Viet Anh");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------");
        try {
            FileReader reader = null;
            reader=new FileReader(file);
            char[] buffer = new char[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
//            while ((read=reader.read(buffer))!=1){
//                builder.append(buffer,0,read);
//            }
            System.out.println(builder);
        reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
