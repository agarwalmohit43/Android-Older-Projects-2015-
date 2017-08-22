package world.hhhh;

public class selection {

	public static void main(String[] args) {
		 int[] arr1 = {10,34,2,56,7,67,88,42};
	        int[] arr2 = selection(arr1);
	        for(int i:arr2){
	            System.out.print(i);
	            System.out.print(", ");
	        }
	}

	private static int[] selection(int arr[]) {
		
		for(int i=0;i<arr.length-1;i++)
		{
			int index=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[index]>arr[j]){
					index=j;
				}
			}
			if(index!=i){
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
		}
		return arr;
	}

}
