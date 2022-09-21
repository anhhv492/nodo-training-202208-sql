package io;

import java.io.File;

public class FileExample {
    private static long getSize(File file){
        if(file.isFile()){
            return file.length();
        }
        File[] files = file.listFiles();
        int length=0;
        for(int i=0;i<files.length;i++){
            if(files[i].isFile()){
                length+=files[i].length();
            }else{
                length+=getSize(files[i]);
                continue;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        File file =new File("C:\\temp");
        System.out.println("this is "+(file.isFile()?"file":"folder"));
        if(file.isFile()){
            System.out.println("this is file"+file.getName());
        }else{
            System.out.println("this is folder"+file.getName());
        }
        File[] files = file.listFiles();
        for(File f:files){
            System.out.println(f.getName()+":"+f.length()+"bytes");
        }
        System.out.println("Size:" +getSize(file)/(1024*1024)+"MB");
    }
}
