package thread;

import java.util.Arrays;

public class DeadLockTest {
    public static void main(String[] args) {
//        Object obj1 = new Object();
//        Object obj2 = new Object();
        String[] obj1 = {"obj1","viet anh"};
        String[] obj2 = {"obj2","dragon"};
        DeadLockDemo thread1 = new DeadLockDemo(obj1,obj2);
        thread1.setName("thread1");
        DeadLockDemo thread2 = new DeadLockDemo(obj2,obj1);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }
}
