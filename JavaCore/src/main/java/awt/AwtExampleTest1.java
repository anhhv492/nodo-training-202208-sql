package awt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtExampleTest1 {
    public static void main(String[] args) {
        AwtExample1 screen = new AwtExample1();
        screen.setSize(500,600);
        screen.setVisible(true);
        screen.setResizable(false);
        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
