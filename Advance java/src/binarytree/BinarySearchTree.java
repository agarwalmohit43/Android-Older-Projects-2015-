package binarytree;

public class BinarySearchTree {

	public Node root;
	
	public BinarySearchTree(){
		root=null;
	}
	public void insert(int data){
		
		Node newnode=new Node();
		newnode.data=data;
		if(root==null){
			root=newnode;
		}else{
			Node current=root;
			Node parent;
			while(true){
				parent=current;
				
				if(data<current.data){
			//		current=current.left;
				
				if(current==null){
				//	parent.left=newnode;
					break;
				}}else{
					//current=current.right;
					
					if(current==null){
						//parent.right=newnode;
						break;
					}
				}
			}
		}
		
	}
	
	
}
