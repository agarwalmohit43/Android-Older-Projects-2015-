interface one{
	void display();
}

interface two{
	void notDisplay();
}
public class multipleinterface implements one,two {

	@Override
	public void notDisplay() {
System.out.println("hi");		
	}

	@Override
	public void display() {
		System.out.println("his");
		
	}
	
	public static void main(String[] args){
		multipleinterface ob=new multipleinterface();
		ob.display();
		ob.notDisplay();
	}

}
