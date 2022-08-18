package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\temp"+File.separator+"test.txt");
        FileOutputStream outputStream=null;
        try{
            outputStream = new FileOutputStream(file);
            //byte[] bytes = "Việt Anh Test".getBytes();
            String bytes = "Việt Anh Test";
            outputStream.write(bytes.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(outputStream!=null){
                outputStream.close();
            }
        }
        System.out.println("--------------");
        try{
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[100];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
            bytes = new byte[4*1024];
            int read =-1;
            StringBuilder builder = new StringBuilder();
            while ((read=inputStream.read(bytes))!=-1){
                builder.append(new String(bytes,0,read));
            }
            System.out.println("["+builder+"]");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
