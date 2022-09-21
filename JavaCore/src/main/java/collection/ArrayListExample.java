package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list,args);
        System.out.println("cach 1");
        for(int i=0;i<list.size();i++){
            System.out.println("Element at: "+i+" is"+list.get(i));
        }
        System.out.println("cach 2");
        IntStream.range(0,list.size()).forEach(i->{
            System.out.println("Element at: "+i+" is"+list.get(i));
        });
    }
}
