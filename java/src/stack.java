import java.util.*;
public class stack {

	static void pushs(Stack st,int a){
		st.push(a);
		System.out.println(st);
	}
	
	static void pop(Stack st){
		
		st.pop();
		System.out.println(st);
	}
	public static void main(String[] args){
		Stack st=new Stack();
		pushs(st,49);
		pop(st);
		pop(st);
		try{
			pop(st);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
