package binarytree;

public class Node {

	public int data;
	public int left;
	public int right;
	
	public Node(int data){
		this.data=data;
		left=(Integer) null;
		right=(Integer) null;
		
	}
	public Node(){
		left=(Integer) null;
		right=(Integer) null;
	}

	int getdata(){
		return data;
	}
}
