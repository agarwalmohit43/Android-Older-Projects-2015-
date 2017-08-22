package world.hhhh;
import java.io.*;
//import java.util.Scanner;


public class reversestring {

	public static void main(String[] args) throws IOException
	{
		//String a="mohit agarwal",reverse="";
		/*int length=a.length();
		for(int i=length-1;i>=0;i--)
		{
			reverse=reverse+a.charAt(i);
		}
		System.out.print(reverse);*/
		
		//Scanner in=new Scanner(System.in);
		System.out.println("Enter the String");
		//String string=in.next();
	      
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String string=br.readLine();
	
		String reverse = new StringBuffer(string).reverse().toString();
	      System.out.println("\nString before reverse: "+string);
	      System.out.println("String after reverse:"+reverse);
	      
	      if(string.equals(reverse))
	      {
	    	  System.out.println("String is palimdrome");
	    	  
	      }else{
	    	  System.out.println("String is not a palimdrome");

	      }
	      br.close();
		
	}
}
