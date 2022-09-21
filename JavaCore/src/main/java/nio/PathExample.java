package nio;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("C:\\temp");
            System.out.println("this is: "+(Files.isDirectory(path)?"file":"folder"));
            System.out.println(Files.exists(path));
            DirectoryStream directoryStream = Files.newDirectoryStream(path);
            for (Object p:directoryStream){
                System.out.println(p);
            }

            Path path2 = path.resolve("test.txt");
            Charset charset = Charset.forName("utf8");
            try(BufferedReader reader=Files.newBufferedReader(path2,charset)){
                String line =null;
                while ((line=reader.readLine())!=null){
                    System.out.println(line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
