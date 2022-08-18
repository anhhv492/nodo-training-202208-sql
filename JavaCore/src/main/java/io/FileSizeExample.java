package io;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    static long getSize(File file){
        if(file.isFile()){
            return file.length();
        }
        AtomicLong length=new AtomicLong(0);
        Arrays.stream(file.list()).forEach(f->{
            length.getAndSet( length.longValue()+f.length());
        });
        return length.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\temp");
        System.out.println("Size: "+getSize(file)+"MB");
    }
}
