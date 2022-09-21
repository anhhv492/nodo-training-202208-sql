package thread;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable{
    private String message=null;

    public PrintMessage(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        String[] elements = message.split(" ");
        Arrays.stream(elements).forEach(ele->{
            System.out.println(Thread.currentThread().getName()+"print"+ele);
            try {
//                TimeUnit.SECONDS.sleep(1);
                Thread.sleep((int)(Math.random()*3)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
