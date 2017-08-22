import cal.mohitcal;
import java.util.*;
public class mohit {
	public static void main(String[] args)
	{   
		calci();
		}
		
	public static void calci()
		{ 
		Scanner in=new Scanner(System.in);
		mohitcal on=new mohitcal();
		try
		{	
		System.out.println("Enter ur choice");
		System.out.println("1.ADDITION");
		System.out.println("2.SUBTRACTION");
		System.out.println("3.DIVISION");
		System.out.println("4.MULTIPLICATION");
		System.out.println("5.EXIT");
		int x=in.nextInt();
		
		switch(x){
		case 1:System.out.println("Enter 1st No:");
		double a=in.nextDouble();
		       System.out.println("Enter 2nd No:");
		       double b=in.nextDouble();
		       on.sum(a, b);
		       on.display(1);
		       break;
		       
		case 2:System.out.println("Enter 1st No:");
		double d=in.nextDouble();
	       System.out.println("Enter 2nd No:");
	       double e=in.nextDouble();
	       on.subtract(d,e);
	       on.display(2);
	       break;
		case 3:System.out.println("Enter 1st No:");
		double q=in.nextDouble();
	       System.out.println("Enter 2nd No:");
	       double w=in.nextDouble();
	       on.div(q,w);
	       on.display(3);
	       break;
		case 4:System.out.println("Enter 1st No:");
	       double t=in.nextDouble();
	       System.out.println("Enter 2nd No:");
	       double y=in.nextDouble();
	       on.mul(t,y);
	       on.display(4);
	       break;
		case 5:System.exit(0);
	       default:System.out.println("INVALID CHOICE");
	       }}
		finally{
			calci();
		}
		}
	}


