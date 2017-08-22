import java.util.Scanner;

public class pattern {

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the limit");
		int a=in.nextInt();
		
				int c=a;
				for(int i=1;i<=a;i++)
				{
					for(int m=1;m<=c;m++)
					{
						System.out.print(" ");
						
					}
					for(int j=1;j<=i;j++)
					{
						System.out.print(j);
						}
					
					for(int k=i-1;k>=1;k--)
					{
						System.out.print(k);
						
					}
					System.out.println();
					c--;
				}
	}
}
