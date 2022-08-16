package basic1;

public class MethodExample{
	private static int add1(int number1,int number2){
		return number1+number2;
	}
	private static int add2(int ...values){
		int total=0;
		for(Integer so: values){
			total+=so;
		}
		return total;
	}
	public static void main(String[]args){
		//1
		System.out.println("4+7 = "+add1(4,7));
		int value1=Integer.parseInt(args[0]);
		int value2=Integer.parseInt(args[1]);
		System.out.println(value1+"+"+value2+" = "+add1(value1,value2));
		//2
		System.out.println(add2(2,4,6,7,3,2,2));
	}
}
