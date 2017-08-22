package com.example.mohit;

import java.util.Arrays;

public class binarysearch {

	static void display(int[] a) {
		int size = a.length;
		for (int i = 0; i < size; i++) {

			System.out.print(a[i] + " ");

		}
	}

	public static void main(String[] args) {

		int size = 10;
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = (int) (Math.random() * 100);

		}
		System.out.println("Elements in sorted array:");
		Arrays.sort(a);
		display(a);
		int key=25;
		int found=binarysearch(a, key);
		if(found>=0){
			System.out.println("\n Element found at position: "+(found+1));
		}else{
			System.out.println("\nElement not found");

		}
	}

	private static int binarysearch(int[] a, int key) {

		int size=a.length;
		int first=0;
		int last=a.length-1;
		while(first<=last){
			int mid=(first+last)/2;
			if(key>a[mid]){
				first=mid+1;
			}else if(key<a[mid]){
				last=mid-1;
			}else{
				return mid;
			}
		}
	
		return -1;
	}

}
