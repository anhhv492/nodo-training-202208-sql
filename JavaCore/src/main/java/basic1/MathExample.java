package basic1;

public class MathExample{
	public static void main(String[]args){
		int i=4;
		int j=-8;
		double x=47.1;
		double y=1.79;
		System.out.println("|"+j+"|is"+Math.abs(j));
		System.out.println("|"+x+"|is"+Math.abs(x));

		System.out.println(x+"is approximately"+Math.round(x));
		System.out.println("the ceilling of"+i+"is"+Math.ceil(i));
		System.out.println("the ceilling of"+y+"is"+Math.ceil(y));
		System.out.println("the floor of"+x+"is"+Math.floor(x));
		System.out.println("min("+x+","+y+")is"+Math.min(x,y));
		//2
		System.out.println("PI is "+ Math.PI);
		double angle =40.0*2.0*Math.PI/306.0;
		System.out.println("cos("+angle+")is "+Math.cos(angle));

		double value=0.707;
		System.out.println("acos("+value+")is "+Math.acos(value));

		System.out.println("exp(0.0) is "+ Math.exp(0.0));
		System.out.println("log(0.0) is "+ Math.log(10.0));
		System.out.println("pow(2.0,2.0) is "+ Math.pow(2.0,4.0));

		System.out.println("Here's one random number: "+Math.random());
	}
}
