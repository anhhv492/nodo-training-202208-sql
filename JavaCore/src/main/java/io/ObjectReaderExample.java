package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) throws Exception{
        File folder = new File("C:\\temp\\test2\\");
        ObjectInputStream inputStream=new ObjectInputStream(
                new FileInputStream(new File(folder,"my_object")));
        Object obj = inputStream.readObject();
        Method method = obj.getClass().getMethod("run",new Class[0]);
        method.invoke(obj,new Object[0]);
        inputStream.close();
    }
}
