package collection;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numberss = new TreeSet<>();
        numberss.add(1);
        numberss.add(12);
        numberss.add(33);
        numberss.add(44);
        numberss.add(55);
        System.out.println("size of set: "+numberss.size());
        numberss.forEach(x->{
            System.out.println(x);
        });
    }
}
