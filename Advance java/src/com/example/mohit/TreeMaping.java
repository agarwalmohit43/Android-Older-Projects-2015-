package com.example.mohit;

import java.util.*;

public class TreeMaping {
	public static void main(String[] args) {

		TreeMap<String,String> numbers=new TreeMap<String, String>();
		numbers.put("mohit","9051144448");
		
		numbers.put("xyz","9051144448");
		numbers.put("abc","9911554488");
		numbers.put("def","4654658945");
		System.out.println("mohit no: "+numbers.get("mohit"));
	}

}
