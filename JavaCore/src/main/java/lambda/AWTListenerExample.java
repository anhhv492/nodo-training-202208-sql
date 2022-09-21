package lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();
        Button button = new Button("Press me");
        screen.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"welcom to java by example","java sample",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        button.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"Lambda");
        });
        screen.setSize(250,400);
        screen.setVisible(true);
        screen.setResizable(false);
        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        screen.setLocationRelativeTo(null);
    }
}
