package nio;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchFolderExample {
    public static void watch(Path path){
        FileSystem fs = path.getFileSystem();
        try(WatchService service = fs.newWatchService()){
            path.register(service);
            while (true){
                WatchKey key=service.take();
                if(!key.reset()){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("C:\\temp");
        watch(path);
    }
}

