package basic1;

public class StringExample2{
	public static void main(String[]args){
		//1
		char[]chars={'h','e','i','l','o'};
		String text=new String(chars);
		System.out.println(text);
		//2
		text=text.concat(" ");
		text=text.concat(args[0]);
		System.out.println("new value is "+text);
		//3
		System.out.println("new value is "+text);
		System.out.println(args[0].equals("as"));
	}
}
