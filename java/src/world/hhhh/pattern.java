package world.hhhh;


public class pattern {

	public static void main(String[] args){
		int a=5;
		int c=a;
		for(int i=1;i<=a;i++){
			
			for(int m=1;i<=c;m++)
			{
				System.out.print(" ");
				
			}
			
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			
			for(int k=i-1;k>=1;k--){
				System.out.print(k);
			}
			System.out.println();
			c--;
			
			
		}
	}
}
