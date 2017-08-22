import java.util.ArrayList;
import java.util.Arrays;


public class arra {
public static void main(String[] args){
	
	int arr[]={50,20,60,40,1,89};
	int b=arr.length;
	/*for(int i=0;i<b;i++){
		
		arr[i]=arr[i]*10;
		System.out.println(arr[i]);
		
	}*/
	Arrays.sort(arr);
	for(int a:arr){
		System.out.println(a);
		int index=Arrays.binarySearch(arr, a);
		System.out.println(index);
	}

			for(int i = 0;true; i++) {
				System.out.println("Hello");
				break;
				
			}
			
			ArrayList al=new ArrayList();
			al.add(5);
			al.add(8);
			System.out.println(al);
			
		
	
	
	
}
}
