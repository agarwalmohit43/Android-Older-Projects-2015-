package confuse;

import java.util.Arrays;

class returnarray{
	public int[] arr(int[] arr){
		Arrays.sort(arr);
		return arr;
		
	}
}
public class Arrayprops {

	public static void main(String[] args) {

		int[] a={55,11,22,44,9,454,45,2};
		
		int[] b;
		returnarray ob=new returnarray();
		b=ob.arr(a);
		System.out.print("Values in Sorted Form: ");
		for(int i=0;i<b.length;i++){
		System.out.print(b[i]+" ");
		}
	}

}
