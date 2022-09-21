package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriterExample {
    public static void main(String[] args) throws Exception{
        File folder = new File("C:\\temp\\test2\\");
        ObjectOutputStream outputStream = null;
        FileOutputStream fileOutPut=new FileOutputStream(new File(folder,"my_object"));
        outputStream = new ObjectOutputStream(fileOutPut);
        PrintMessage printMessage = new PrintMessage("Ha Viet Anh");
        outputStream.writeObject(printMessage);
    }
}
