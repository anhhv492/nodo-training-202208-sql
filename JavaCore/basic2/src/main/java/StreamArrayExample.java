import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        Integer[] values={1,2,5,4,7,1,3,5,11,55,12,2};
        Arrays.sort(values, (Integer o1,Integer o2)-> {
            return o2-o1;
        });
        for (String ids:args){
            System.out.println(ids);
        }
        System.out.println("-----------------");
        Arrays.stream(values).forEach(value-> System.out.println(value));
        System.out.println("-----------------");
        Stream<Integer> stream=Arrays.stream(values);
//        stream.forEach(value-> System.out.println(value));
    //EX2
        Optional<Integer> max =stream.max((Integer o1, Integer o2)->{
           return o1-o2;
        });
        System.out.println("max number in values: "+max.get());
     //ex3
        stream = Arrays.stream(values);
        Predicate<Integer> predicate = (Integer value)->{
            return value>5;
        };
        Stream<Integer> older = stream.filter(predicate);
        older.forEach((Integer value)->{
            System.out.println(value);
        });
    }

}
