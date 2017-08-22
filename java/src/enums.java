import java.util.Vector;
import java.util.Enumeration;
public class enums {

	public static void main(String[] args){
		Enumeration days;
		Vector daynames=new Vector();
		daynames.add("sunday");
		daynames.add("monday");
		daynames.add("tuesday");
		daynames.add("wednesday");
		daynames.add("thursday");
		daynames.add("friday");
		daynames.add("saturday");
		days=daynames.elements();
		while(days.hasMoreElements()){
			System.out.println(days.nextElement());
		}
		
	}
	
}
