package world.hhhh;

public class patternequitraingle {
	
	public static void main (String... args)
			{
			int c=20;
			for(int i=65;i<=70;i++){
				
				for(int m=1;m<=c;m++){
					System.out.print(" ");
				}
				for(int j=65;j<=i;j++){
					System.out.print((char) j);
				}
				
				for(int k=i-1;k>=65;k--)
				{
					System.out.print((char)k);
				}
				System.out.println();
				c--;
			}
			
			}
}
