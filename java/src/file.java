import java.io.FileNotFoundException;
import java.util.*;
public class file {
	static Formatter x;
	public static void main(String[] args){
		
		openFile();
	}
	
	public static void openFile(){
		
		try {
			x=new Formatter("mohit.txt");
			System.out.println("Created Successfully"+x);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRecords(){
		x.format("%s %s %s", "Mohit","Kumar","Agarwal");
	}

	public void closeFile(){
		x.close();
	}
	
}
