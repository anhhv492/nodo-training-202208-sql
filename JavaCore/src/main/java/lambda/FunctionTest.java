package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Consumer<Student> c =(Student student)->{
            if(student.getAge()>23){
                student.setAge(23);
            }
            students.add(student);
        };
        c.accept(new Student("Nguyen A",34));
        System.out.println(students.get(0));
        String[] names = {"Ha viet anh","Viet Anh Ha"};
        Integer[] ages={23,12,21,22};
        IntStream intStream = IntStream.rangeClosed(0,names.length-1);
        Stream<Student> stream = IntStream.empty().mapToObj(value -> new Student(names[value],ages[value]));
        Consumer<Student> c2 = (Student student)->{
            System.out.println(student);
        };
        System.out.println("asd");
        Function<Student,String> jsonToFunction = (Student student)->{
          StringBuilder builder = new StringBuilder();
          builder.append("student{\n");
          builder.append("\tid:").append(student.getId()).append('\n');
          builder.append("\tname:").append(student.getAge()).append('\n');
          builder.append("}");
          return builder.toString();
        };
        c = (Student student)->{
            System.out.println(jsonToFunction.apply(student));
        };
        Predicate<Student> predicate = (Student student)->{
            return student.getAge()>30;
        };
        Stream<Student> older =stream.filter(predicate);
        older.forEach(c);
        Supplier<Student> supplier=()->{
            return new Student("Tran thi a",24);
        };
        System.out.println(jsonToFunction.apply(supplier.get()));
    }
}
