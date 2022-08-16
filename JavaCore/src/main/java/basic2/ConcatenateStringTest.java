package basic2;

public class ConcatenateStringTest {
    public static void main(String[] args) {
        int max = 10000;
        StringBuilder builder = new StringBuilder(1000);
        long start = System.currentTimeMillis();
        for(int i=0;i<max;i++){
            builder.append(String.valueOf(i));
        }
        System.out.println("time1= "+(System.currentTimeMillis()-start));
        System.out.println(start+", "+System.currentTimeMillis());
        StringBuffer buffer=new StringBuffer(2000);
        for (int i=0;i<max;i++){
            buffer.append(String.valueOf(i));
        }
        System.out.println("time2= "+(System.currentTimeMillis()-start));
        String text="";
        start = System.currentTimeMillis();
        for(int i=0;i<max;i++){
            text+=String.valueOf(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time 3: "+(end-start));

    }
}
