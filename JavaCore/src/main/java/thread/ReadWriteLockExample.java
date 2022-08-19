package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();
        Runnable writeTask= () -> {
            System.out.println("start writing!");
            lock.writeLock().lock();
            try{
                TimeUnit.SECONDS.sleep(3);
                map.put("foo","bar");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
                System.out.println("End writing");
            }
        };
        Runnable readTask =()->{
            System.out.println("start reading");
            lock.readLock();
            try {
                System.out.println(map.get("foo"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("End reading");
                lock.readLock().unlock();
            }
        };
        executor.submit(writeTask);
        executor.submit(readTask);
    }
}
