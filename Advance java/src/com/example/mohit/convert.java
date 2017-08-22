package com.example.mohit;

import java.util.Stack;

public class convert {

	static String binary(int number){
		final int base=2;
		Stack s=new Stack();
		do{
			s.push(number%base);
			number/=base;
		}while(number!=0);
		String bits="";
		while(!s.empty()){
			bits+=s.peek();
			s.pop();		
		}
		return bits;
	}
	
	public static void main(String[] args){
		int num=5;//101
		
		System.out.println(num+" binary is:"+binary(num));
	}
	
}
