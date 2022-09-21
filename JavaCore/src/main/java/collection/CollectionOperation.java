package collection;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        //1
        List<Integer> listOfIntegers=new ArrayList<>(Arrays.asList(4,7,8,9,5,3));
        Comparator<Integer> comparator=Integer::compare;
        Collections.sort(listOfIntegers,comparator);
        listOfIntegers.stream().filter(v->v>5).forEach(v->{
            System.out.println(v);
        });
        Integer[] values = listOfIntegers.stream().filter(v->v>5)
                .toArray(size->new Integer[size]);
        Arrays.stream(values).forEach(v-> System.out.println(v));
        System.out.println("---------------");
        //2
        Collector<Integer,?,IntSummaryStatistics> collector= Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);
        System.out.println("total= "+summaryStatistics.getSum());
        System.out.println("overage= "+summaryStatistics.getAverage());
        int sum = listOfIntegers.stream().reduce(0,(x,y)->x+y);
        int sum2= listOfIntegers.stream().reduce(0,Integer::sum);
        System.out.println("sum1: "+sum);
        System.out.println("sum2: "+sum2);
        //3
        System.out.println("---------------");
        Consumer<Integer> myConsumer = n->{
            System.out.println("user input value="+n);
            if(n<5){
                System.out.println("invalid value!"+n);
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: "+n);
            listOfIntegers.forEach(x->{
                System.out.printf(x+"-");
            });
        };
        myConsumer.accept(12);
        //4
        Scanner scanner = new Scanner((System.in));
        while (true){
            System.out.println("Please input a number1: ");
            int value = scanner.nextInt();
            myConsumer.accept(value);
            break;
        }
        //5
        Predicate<Integer> tester = v-> v > 5;
        Consumer<Integer> myConsumer2=n->{
            listOfIntegers.add(n);
        };
        while (true){
            System.out.println(" please input a number2:");
            int value =scanner.nextInt();
            if(value<0){
                break;
            }
            if (tester.test(value)) {myConsumer2.accept(value);};
        }
        listOfIntegers.forEach(x-> System.out.print(x+"-"));
    }
}
