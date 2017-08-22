package com.example.mohit;
import java.util.*;
public class stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack names=new Stack();
		names.push("mohit");
		names.push(5);
		System.out.println(names);

		System.out.println("elements: "+names.peek());
		System.out.println("poped element: "+names.pop());
		System.out.println("poped element: "+names.pop());
		
	}

}
