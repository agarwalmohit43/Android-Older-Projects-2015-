package com.example.mohit;
public class quicksort {
	public static void display(int[] a) {
		int size = a.length;
		System.out.println("Elements after sorting: ");
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] a = new int[] { 10, 2, 55, 9, 7, 44, 5, 8, 25, 6 };
		System.out.println("unsorted array:");
		display(a);
		quicksort(a, 0, a.length - 1);
		System.out.println("sorted array:");
		display(a);
	}
	private static void quicksort(int[] a,int left,int right) {
		int i = left;
		int j = right;
		int temp;
		int pivot = a[(left + right) / 2];
		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j) 
			quicksort(a, left, j);
		if (i < right) 
			quicksort(a, i, right);
	}
}
