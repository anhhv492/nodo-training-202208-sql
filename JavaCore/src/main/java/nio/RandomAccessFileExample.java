package nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Path path = Path.of("C:\\temp\\test.txt");
        ByteBuffer buffer = ByteBuffer.allocate(15);
        try (FileChannel fc = FileChannel.open(path)){
            fc.read(buffer);
            System.out.println(new String(buffer.array()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
