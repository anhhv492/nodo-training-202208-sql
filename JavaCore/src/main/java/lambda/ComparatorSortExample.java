package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortExample {
    public static void main(String[] args) {
        Integer[] values={12,345,33,6,10,9};
//        Arrays.sort(values, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        Arrays.sort(values,(Integer o1, Integer o2)->{
            return o1-o2;
        });
        System.out.println();
        for (Integer ele:values){
            System.out.print(ele+", ");
        }

    }
}
