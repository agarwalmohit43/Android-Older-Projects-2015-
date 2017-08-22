import java.util.Scanner;

public class test {
	
	public static void main()
	{
		exception ob=new exception();
		System.out.println("enter the age");
		int umar=new Scanner(System.in).nextInt();
        ob.setage(umar);
        System.out.print("your age"+ob.getage());
	
	
	
	}
}
