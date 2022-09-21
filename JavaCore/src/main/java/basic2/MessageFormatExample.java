package basic2;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.DataFormatException;

public class MessageFormatExample {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("EEEE,dd/MM/yyyy");
        String message = MessageFormat.format(
                "Hello {0}!Today is {1}.",args[0],
                dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }
}
