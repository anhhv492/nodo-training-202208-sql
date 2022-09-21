package basic2;

import java.util.prefs.Preferences;

public class PreferencesExample {
    public static void main(String[] args) {
        Preferences preferences=Preferences.userNodeForPackage(PreferencesExample.class);
        System.out.println("Old value="+ preferences.get("data1","no value"));
        preferences.put("data1","value"+System.currentTimeMillis());
        preferences.put("data2","preferences");
        System.out.println("value2="+preferences.get("data2","no value"));

    }
}
