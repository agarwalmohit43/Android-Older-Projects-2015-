package cal;

import java.util.Scanner;

public class binarysearch {

	public static void main(String[] args) {
		int n,l,u,mid,element,pos=0,flag = 0;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the no. of values to be entered");
		n=in.nextInt();
		int arr[]=new int[n];
			for(int i=0;i<n;i++)
			{
				System.out.print("Enter the value at "+(i+1)+" position: ");
				arr[i]=in.nextInt();
			}
	
			System.out.print("Enter the element to be searched: ");
			element=in.nextInt();
			l=0;u=n-1;
			while(l<=u){
				mid=(l+u)/2;
				if(arr[mid]==element){
					flag=1;pos=mid+1;break;
				}else if(element<=arr[mid]){
					u=mid-1;
				}else{
					l=mid+1;
				}
				
			}
			
			if(flag==1){
				System.out.println("\nElement found at: "+pos);
			}else{
				System.out.println("Element Not Present");
			}
			
	}

}
