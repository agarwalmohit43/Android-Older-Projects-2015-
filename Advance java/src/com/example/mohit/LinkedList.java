package com.example.mohit;

public class LinkedList {

	
	public static void main(String[] args) {

		Node<String> a=new Node<String>("Mohit");
		Node<String> b=new Node<String>("Kumar");
		Node<String> c=new Node<String>("Agarwal");
		Node<String> e=new Node<String>("coder");

		a.next=b;
		b.next=c;
		c.next=e;
		e.next=null;
		Node<String> dummy;
		dummy=a;
		while(dummy.next!=null){
			System.out.println(dummy.getdata());
			dummy=dummy.next;
		}

	}

}
