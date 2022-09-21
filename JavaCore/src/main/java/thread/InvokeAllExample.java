package thread;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokeAllExample{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        CallableSample callableSample = new CallableSample();
        List<CallableSample> callables = Arrays.asList(callableSample,callableSample,callableSample);
        Stream<Result> stream = (Stream<Result>) executor.invokeAll(callables);
        stream.map(future->{
           return future.getSystemId();
        });
        Object[] results = stream.toArray(Integer[]::new);
        Arrays.stream(results).forEach(x->{
            System.out.println();
        });
    }
}
