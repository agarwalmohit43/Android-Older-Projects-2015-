package com.example.mohit;

public class insertion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int size=10;
		int[] a=new int[size];
		for(int i=0;i<size;i++){
			a[i]=(int)(Math.random()*100);
			
		}
		System.out.println("Elements before sorting in array:");
		for(int i=0;i<size;i++){
			
			System.out.print(a[i]+" ");

		}
		
		for(int i=0;i<size;i++){
			for(int j=i;j>0;j--){
				if(a[j-1]>a[j]){
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
		System.out.println("\n\nElements  After sorting in array:");
		for(int i=0;i<size;i++){
			
			System.out.print(a[i]+" ");

		}
		
		
	}

}
