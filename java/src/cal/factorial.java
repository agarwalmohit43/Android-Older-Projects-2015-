package cal;
import java.util.*;

public class factorial {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the no: ");
		int n=in.nextInt();
		int f;
		f=fact(n);
		System.out.println("Factorial of: "+n+" is: "+f);
		

	}

	private static int fact(int n) {
		if(n==0)
		{
			return 1;
			
		}else{
			return (n*fact(n-1));
		}
		
	}

}
