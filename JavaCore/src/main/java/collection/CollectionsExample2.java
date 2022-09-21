package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Ha","An","Viet","Anh");
        Collections.sort(list);
        list.forEach(x->{
            System.out.printf(x+", ");
        });
        System.out.println("Vi tri thu: "+Collections.binarySearch(list,"Viet"));
    }
}
