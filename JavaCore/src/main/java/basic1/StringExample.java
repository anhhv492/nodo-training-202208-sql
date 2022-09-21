package basic1;

public class StringExample{
	public static void main(String[]args){
		String text = "say hello to everyone";
		System.out.println("length of text is: "+text.length());
		System.out.println("cat vi tri tu hello la: "+text.indexOf("hello"));
		System.out.println("cat tu: "+text.substring(4,8));
		
	}
}
