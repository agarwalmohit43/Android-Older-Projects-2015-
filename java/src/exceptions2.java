import java.util.Scanner;
public class exceptions2 {
	public static void main(String[] args)
	{
		div();
	}
	public static void div()
	{
		Scanner in=new Scanner(System.in);
			
		try{
		System.out.println("ENTER THE 1ST NO:");
		int n1=in.nextInt();
		System.out.println("ENTER THE 2ND NO:");
		int n2=in.nextInt();
		double div=n1/n2;
		System.out.println("value after div:"+div);
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			finally
			{
				div();
			}
		
		}
		}
	

