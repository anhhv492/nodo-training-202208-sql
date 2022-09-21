package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtExample1 extends Frame {
    public AwtExample1(){
        setLayout(new FlowLayout());
        Button pushButton=new Button("Press");
        add(pushButton);
        setTitle("vietanhvs");
        final TextField textField = new TextField();
        add(textField);
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });
    }
}
