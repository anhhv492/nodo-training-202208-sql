package collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(3,"viet anh a");
        map.put(2,"viet anh b");
        map.put(4,"viet anh c");
        map.put(1,"viet anh d");
        Iterator<Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        map.descendingMap().forEach((key,value)->{
            System.out.println("key="+key+", value="+value);
        });
    }
}
