import java.util.*;
public class arraylist {

	public static void main(String[] args)
	{
		ArrayList<String> al=new ArrayList<>();
		System.out.println("initial size of ArrayList al:"+al.size());
		
		 al.add("M");
	      al.add("O");
	      al.add("H");
	      al.add("I");
	      al.add("T");
	      al.add(".");
	      al.add("A");
	      al.add("G");
	      al.add("I");
	      System.out.println("Size of al after additions: " + al.size());
	      System.out.println("Contents of al: " + al);
		
	      al.remove(5);
	      al.remove("I");
	      
	      
	      System.out.println("Size of al after deletions: " + al.size());
	      System.out.println("Contents of al: " + al);
	      al.clear();
	      System.out.println("Size of al after clear: " + al.size());
	      System.out.println("Contents of al: " + al);
	      
	}
}
