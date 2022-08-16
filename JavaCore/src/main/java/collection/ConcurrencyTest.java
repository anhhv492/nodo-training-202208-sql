package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,4,5,3,2,6,8,9);
        System.out.println("before remove: size of list="+list.size());
        for (int i=0;i<list.size();i++){
            if(list.get(i)==3){
                list.remove(i);
            }
        }
        System.out.println("after remove: size of list ="+list.size());
    }
}
