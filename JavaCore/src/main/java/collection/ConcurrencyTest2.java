package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,4,5,3,2,6,8,9);
        System.out.println("before remove: size of list="+list.size());
        list.forEach(v->{
            System.out.println(v);
        });
        System.out.println("after remove: size of list ="+list.size());
        //2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next()==3){
                iterator.remove();
            }
        }
        System.out.println("after remove: size of list 2 ="+list.size());
        list.removeIf(item->{return item==5;});
        System.out.println("after remove: size of list 3 ="+list.size());
        list.removeAll(Collections.singleton(4));
        System.out.println("after remove: size of list 4 ="+list.size());
    }
}
