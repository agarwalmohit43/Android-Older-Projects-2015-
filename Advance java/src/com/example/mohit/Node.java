package com.example.mohit;

public class Node<t> {
	private t data;
	public Node next;
	 
	public Node(t data){
		this.data=data;
		next=null;
	}
	t getdata(){
		return data;
	}

}
