import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharaterExample {
    private static int countDigit1(String value){
        int i=0;
        int counter=0;
        while (i<value.length()){
            char so=value.charAt(i);
            if(Character.isDigit(so)){
                counter++;
            }
            i++;
        }
        return counter;
    }
    public static int countDigit2(String value){
        AtomicInteger counter = new AtomicInteger(0);
        IntStream stream = value.chars();
        stream.forEach(c->{
            if(Character.isDigit(c)) {
                counter.incrementAndGet();
            }
        });
        return counter.get();
    }
    public static void main(String[] args) {
        System.out.println("Count number: "+countDigit2(args[0])+": Digits in the text.");

    }
}
