package io;

import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFileNIOExample {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\temp\\test2\\io_sample.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        FileChannel channel = raf.getChannel();
        long value = channel.size();
        FileLock lock = channel.tryLock(0,value,false);
        Desktop.getDesktop().edit(file);
        Thread.sleep(15*1000);
        lock.release();
    }
}
