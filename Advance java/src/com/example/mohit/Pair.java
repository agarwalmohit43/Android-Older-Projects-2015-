package com.example.mohit;

public class Pair<T1, T2> {
	private T1 firstelement;
	private T2 secondelement;

	public Pair(T1 first,T2 second){
		firstelement=first;
		secondelement=second;
	}
	
	public T1 first(){
		return firstelement;
	}
	
	public T2 second(){
		return secondelement;
	}
}
