package basic2;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayExample {
    public static void main(String[] args) {
        Arrays.sort(args);
        for (String index:args){
            System.out.println(index);
        }
        System.out.println("--------------------------------");
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for(String index:args){
            System.out.println(index);
        }
    }
}
