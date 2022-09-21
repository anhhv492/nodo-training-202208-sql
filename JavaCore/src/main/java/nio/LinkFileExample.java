package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class LinkFileExample {
    public static void main(String[] args) {
        Path source = Path.of("C:\\temp\\test.txt");
        Path target = Path.of("C:\\temp\\test2\\io_sample.txt");
        Charset charset = Charset.forName("utf8");
        try(BufferedWriter writer=Files.newBufferedWriter(source,charset)){
            writer.write("java nio 2 example \r\n");
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedReader reader = Files.newBufferedReader(target,charset)){
            String line=null;
            while ((line= reader.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
