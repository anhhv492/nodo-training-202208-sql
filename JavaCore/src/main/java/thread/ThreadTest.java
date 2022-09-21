package thread;

public class ThreadTest {

    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("say he lo");
        new Thread(message).start();
        new Thread(new PrintMessage("say hello viet anh")).start();
    }
}
