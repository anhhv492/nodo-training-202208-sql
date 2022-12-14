package lambda;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"say hello java class!");
            }
        };
        new Thread(runnable).start();
        //------------
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"say hello java class!");
            System.out.println("1+1= "+(1+1));
        }).start();
    }
}
