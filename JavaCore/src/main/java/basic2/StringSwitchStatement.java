package basic2;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    String getTypeOfDay(Calendar calendar) {
        String type=calendar.getDisplayName(calendar.DAY_OF_WEEK,calendar.SHORT,
                new Locale("vi"));
        switch (type){
            case "Th 2": return "Start of work week";
            case "Th 3": return "thu3";
            case "Th 4": return "thu4";
            case "TH 5": return "thu5";
            case "TH 6": return "end of work week";
            case "Th 7": return "thu7";
            case "CN": return "Weekend";
        }
        return "unknown";
    }

    public static void main(String[] args) {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("today is: "+statement.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+1);
        System.out.println("Tomorow is "+statement.getTypeOfDay(calendar));

    }
}
