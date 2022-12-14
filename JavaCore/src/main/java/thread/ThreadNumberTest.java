package thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("VietAnh_Thread");
        thread.setDaemon(true);
        thread.start();
        while (thread.isAlive()){
            if(number.getNumber()%10==0){
                number.setAlive(false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //step 2
        while (thread.isAlive()){
            if(number.getNumber()%10==0){
                number.setAlive(false);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
