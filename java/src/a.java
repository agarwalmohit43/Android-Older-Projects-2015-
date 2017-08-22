import java.util.Scanner;
public class a {

	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		
		int i,n;
		b bb=new b();
		System.out.println("Enter number of Person:");
        n=in.nextInt();
        for(i=1;i<=n;i++)
        {
        	bb.display(i);
        	
        }
        
	}
}
