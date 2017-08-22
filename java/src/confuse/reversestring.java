package confuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reversestring {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)) ;
		System.out.println("Enter the String:");
		String input=br.readLine();
		char a[]=input.toCharArray();
		System.out.println("Original string: "+input);
		System.out.print("Reverse String: ");
		for(int i=a.length-1;i>=0;i--){
			System.out.print(a[i]);
		}
	}
}
