public class StringExample3{
	public static void main(String[]args){
		//1
		String text="absolute value";
		byte[]bytes = text.getBytes();

		System.out.println("Byte values are");
		for(int i=0;i<bytes.length;i++){
		System.out.println(bytes[i]+",");
		}
	}
}
