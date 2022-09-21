package collection;

import java.util.*;

public class CollectionsExample1 {
    public static void main(String[] args) {
        Short[] values = {1,2,3,4,5,6,7,8,9};
        List<Short> list=new LinkedList<>();
        Collections.addAll(list,values);
        //dao nguoc
        Collections.reverse(list);
        list.toArray(values);
        for (Short x:list){
            System.out.println(x+", ");
        }
        System.out.println("Max: "+Collections.max(list));
        System.out.println("Min: "+Collections.min(list));
    }
}
