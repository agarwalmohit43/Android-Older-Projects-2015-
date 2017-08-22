abstract class mohitAbstract{
	void display(){
		System.out.println("hi");
	}
	
}

interface mohits{
	int a=5;
	void display();
}

public class interfaceExample extends mohitAbstract implements mohits {
	
	public void display(){
		System.out.println("hi interfaceExample");
		System.out.println(a);
	}
	public static void main(String[] args) {
		
		interfaceExample ob=new interfaceExample();
		ob.display();
		
		
		
	}

}
