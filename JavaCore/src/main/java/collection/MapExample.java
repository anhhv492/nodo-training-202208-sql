package collection;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new Hashtable<>();
        map.put(3,"viet anh a");
        map.put(2,"viet anh b");
        map.put(4,"viet anh c");
        map.put(1,"viet anh d");
        System.out.println(map.get(3));
        map.put(3,"nguyen van a");
        System.out.println(map.get(3));
    }
}
