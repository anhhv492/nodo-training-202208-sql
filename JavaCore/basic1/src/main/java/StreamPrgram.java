import java.util.Arrays;

public class StreamPrgram{
	public static void main(String[]args){
		System.out.println("length of argument: "+args.length);
		Arrays.stream(args).forEach((String value)->{
			System.out.println("value is: "+value);
		});
	}
}
