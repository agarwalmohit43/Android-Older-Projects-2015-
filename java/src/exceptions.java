import java.util.*;
public class exceptions {

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int x=1;
		do{
		try{
		System.out.println("ENTER THE 1ST NO:");
		int n1=in.nextInt();
		System.out.println("ENTER THE 2ND NO:");
		int n2=in.nextInt();
		int div=n1/n2;
		System.out.println("value after div:"+div);
		x=2;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}}while(x==1);
	}
	
}
