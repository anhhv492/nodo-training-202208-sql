public class PersonTest{
	public static void main(String[]args){
		Person per1=new Person(args[0]);
		Person per2=new Person(args[1]);
		System.out.println("Person 1 name is: "+per1.getName());
		System.out.println("Person 2 name is: "+per2.getName());
	}
}
