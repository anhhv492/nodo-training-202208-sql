package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritePathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\temp\\test.txt");
        Charset charset = Charset.forName("UTF8");
        try (BufferedWriter writer = Files.newBufferedWriter(path,charset)){
            for(int i=0;i<10;i++){
                writer.write("Hạ Việt "+i+"\r\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
