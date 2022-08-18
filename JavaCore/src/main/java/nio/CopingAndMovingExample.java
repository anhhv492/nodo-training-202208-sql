package nio;

import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopingAndMovingExample {
    public static void main(String[] args) {
        try{
            Path source = Path.of("C:\\temp\\test.txt");
            Path target = Path.of("C:\\temp\\test2\\io_sample.txt");
            Files.copy(source,target,REPLACE_EXISTING);
//            Files.delete(target);
//            Files.createLink(target,source);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
