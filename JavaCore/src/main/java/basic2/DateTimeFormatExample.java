package basic2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("vi","VN");
        SimpleDateFormat dateFormat=new SimpleDateFormat("EEEE,dd/MM/yyyy",locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
