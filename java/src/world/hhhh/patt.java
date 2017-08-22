package world.hhhh;

public class patt {

	public static void main(String... args){
		int c=20;
		for(int i=5;i>=1;i--)
		{
			for(int m=1;m<=c;m++)
			{
				System.out.print(" ");
			}
			for(int j=5;j>=i;j--)
			{
				System.out.print(j);
			}
			for(int k=i-1;k>=1;k--){
				System.out.print(i);
			}
			System.out.println();
			
			
		}
	}
}
