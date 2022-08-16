package collection;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(10);
        vector.add(21);
        vector.add(12);
        vector.add(9);
        System.out.println("Size of vector: "+vector.size());
        System.out.println("Element at 2 "+vector.get(2));
    }
}
