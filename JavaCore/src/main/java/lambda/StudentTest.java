package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student> filter(List<Student> students, lambda.Filter<Student> pred){
        List<Student> list = new ArrayList<>();
        for(Student student:students){
            if(pred.valid(student)){
                list.add(student);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tran Van A",23));
        students.add(new Student("Tran Van B",33));
        students.add(new Student("Tran Van C",13));
        students.add(new Student("Tran Van D",43));
        Filter<Student> older = student->
            student.getAge()>=30;
        List<Student> filtered=filter(students,older);
        for (Student student:filtered){
            System.out.println(student);
        }
        System.out.println("-----------");
        filtered.forEach(student -> System.out.println(student));
        System.out.println("-----------");
        Stream<Student> stream = students.stream().filter(student -> student.getAge()>=30);
        stream.forEach(student -> System.out.println(student));
        System.out.println("-----------");
        Collections.sort(students,(Student s1, Student s2)->
            s1.getAge() - s2.getAge());
        students.forEach(student -> System.out.println(student));
        System.out.println("-----------");
        Stream<Student> stream1 = students.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge());
        stream1.forEach(x-> System.out.println(x));
        Comparator<Student> comparator=(s1,s2)->s1.getAge()-s2.getAge();
        Stream<Student> stream2 = students.stream().sorted(comparator);
        stream2.forEach(student -> System.out.println(student));
        //max
        System.out.println("max is: "+students.stream().max(comparator));
        int sum = students.stream().mapToInt(s->s.getAge()).sum();
        System.out.println("Average of age is "+sum/students.size());
        students.parallelStream().forEach((it)-> System.out.println(Thread.currentThread().getName()+"hello"+it.getName()));
    }
}
