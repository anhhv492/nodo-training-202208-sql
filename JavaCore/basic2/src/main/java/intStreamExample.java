import java.util.stream.IntStream;
import java.util.stream.Stream;

public class intStreamExample {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("5");
        IntStream stream= IntStream.range(0,10);
        stream.forEach(value->{
            if(builder.length()>0){
                builder.append(',');
                builder.append(value);
            }
        });
        System.out.println("text value="+builder);
    }
}
