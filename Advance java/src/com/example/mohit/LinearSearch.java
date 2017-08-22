package com.example.mohit;

public class LinearSearch {

	public static int min(int[] a){
		int minimum=a[0];
		for(int i=0;i<a.length;i++){
			if(a[i]<minimum){
				minimum=a[i];
			}
		}
		return minimum;
	}

	public static void main(String[] args) {
	
	int a[]=new int[]{5,10,4,88,77,22,4,6,8,7,2};
	int minimum=min(a);
	System.out.println("the minimum value in array a[] is:"+minimum);
	int element=544;
	int i;
	for(i=0;i<a.length;i++){
		if(a[i]==element){
			System.out.println("element found at psoition:"+(i+1));
			break;
		}
	}
	if (i == a.length) 
	      System.out.println(element + " is not present in array.");
	  }	
	}

