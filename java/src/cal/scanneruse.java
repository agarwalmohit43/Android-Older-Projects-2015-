package cal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class scanneruse {

	public static void main(String[] args) throws IOException {

		Scanner in=new Scanner(System.in);
		System.out.println("Enter ur name: ");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s=br.readLine();
		
		System.out.println("ur anme:"+s);
	}

}
