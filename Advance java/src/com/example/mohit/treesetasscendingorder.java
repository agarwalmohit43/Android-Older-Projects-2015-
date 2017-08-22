package com.example.mohit;

import java.util.TreeSet;

public class treesetasscendingorder {

	public static void main(String[] args) {

	TreeSet<String> names=new TreeSet<String>();
	names.add("MOHIT");
	names.add("ilu");
	names.add("neha");
	names.add("abhishek");
	names.add("sweety");
	names.add("sikha");
	names.add("priyanka");
	names.add("hello");
	System.out.println("Size of treeset:"+names.size());
	System.out.println("first element in the treeset is:"+names.first());
	System.out.println("last element in the treeset is:"+names.last());
	System.out.println("names before mohit"+names.lower("mohit"));
	System.out.println("names after mohit"+names.higher("mohit"));
	for(String name:names){
		System.out.println(name.toUpperCase());
	}
	
	names.remove("hello");
	for(String na:names){
		System.out.println(na.toUpperCase());
	}
	}

}
