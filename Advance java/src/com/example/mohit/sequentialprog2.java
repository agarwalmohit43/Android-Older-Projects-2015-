package com.example.mohit;

import java.util.*;
import java.io.*;

public class sequentialprog2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<String> men = new PriorityQueue<String>();
		PriorityQueue<String> women = new PriorityQueue<String>();
		String sex = "";
		String line = null;
		String file = "C:\\Users\\MOHIT AGARWAL\\Desktop\\Advanced Java Programming - Working Files\\Chapter 03\\dance.txt";
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			while ((line = in.readLine()) != null) {
				sex = line.substring(0, 1);
				if (sex.equals("M")) {
					men.add(line.substring(2));
				} else {
					women.add(line.substring(2));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		while (!men.isEmpty() && !women.isEmpty()) {
			System.out.println("The Dance Partner are");
			System.out.println(men.poll() + " and " + women.poll());
			System.out.println();
		}
		if (men.isEmpty()) {
			System.out.println("Women left" + women.size());

			for (String wo : women) {
				System.out.println("Names of women left are:" + wo);

			}
		}
		if (women.isEmpty()) {
			System.out.println("Men left" + men.size());

			for (String m : men) {
				System.out.println("Names of men left:" + m);
			}

		}

	}

}
