package com.example.mohit;

public class Mergesort {

	
	public static void mergesort(int[] arr,int low,int high){
		int size=arr.length;
		if(low<high){
			int middle=(low+high)/2;
			
			mergesort(arr,low,middle);
			mergesort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
		
	}
	
	public static void merge(int[] arr,int low,int middle,int high){
		
		int size=arr.length;
		int temp[]=new int[size];
		for(int i=low;i<=high;i++){
			temp[i]=arr[i];
		}
		
		int i=low;
		int j=middle+1;
		int k=low;
		
		while(i<=middle && j<=high){
			if(temp[i]<=temp[j]){
				arr[k++]=arr[i++];
			}else{
				arr[k++]=arr[j++];
			}
			while(i<=middle){
				arr[k++]=temp[i++];
			}
			
			
		}
	}
	
	public static void main(String[] args) {

		int low=0;
		int high=9;
		int size = 10;
		int[] a = new int[] { 10, 2, 55, 9, 7, 44, 5, 8, 25, 6 };
		System.out.println("Elements before sorting in array:");
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}

		mergesort(a, low, high);
		System.out.println("\n\nElements  After sorting in array:");
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}

	}

}
