package com.example.mohit;
import java.util.PriorityQueue;
public class priortyqueue {
	public static void main(String[] args) {
		PriorityQueue<String> names=new PriorityQueue<String>();
		names.add("mohit");
		names.add("sweety");
		names.add("abhishek");
		names.add("sikha");
		for(String name:names){
				System.out.println(name);
		}
		System.out.println("First in queue:"+names.peek());
		
		
	}

}
