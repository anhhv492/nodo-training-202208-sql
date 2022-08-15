public class ArrayExample{
	public static void main(String[]args){
		//1
		float[] values={4.5f,5.5f,1.5f,2.5f,3.5f,4.5f,9f,2f};
		float total=0;
		for(float value:values){
			total+=value;
		}
		System.out.println("The total value of array is: "+total);
		//2
		float max=values[0];
		for(int i=0;i<values.length;i++){
			if(max<values[i]){
				max=values[i];
			}
		}
		System.out.println("Gia tri lon nhat: "+max);
		
	}
}
