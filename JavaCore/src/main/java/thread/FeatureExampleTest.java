package thread;

import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) {
        try {
            CallableSample callableSample = new CallableSample();
            System.out.println("----------------");
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(callableSample);
            System.out.println("future done? "+future.isDone());
            Integer result =future.get(1,TimeUnit.SECONDS);
//            System.out.println("Future done?"+future.isDone()+"-result= "+result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
