package thread;

public class SynchronizedStatementExample {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("FSoft_Thread 1");
        thread.start();
        Thread thread1 = new Thread(number);
        thread1.setName("FSoft_Thread 2");
        thread1.start();
    }
}
