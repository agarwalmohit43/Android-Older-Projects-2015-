import java.util.Scanner;

class Emp
{
	public static void main(String args[])
	{
		int i,n,idd,sal;
		String nam,add;
		Employee[] staff=new Employee[100];
		System.out.println("\n\nEnter no of employees:");
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		for(i=0;i<n;i++)
		{
			System.out.println("\n\nEnter data of Employee "+(i+1));
			System.out.println("Enter Name:");
			nam=in.next();
			System.out.println("Enter Address:");
			add=in.next();
			System.out.println("Enter Salary:");
			sal=in.nextInt();
			System.out.println("Enter ID:");
			idd=in.nextInt();
			staff[i]=new Employee(nam,add,idd,sal);
		}
		System.out.println("\n\n--------------------Employee Data--------------------");
		for(i=0;i<n;i++)
		{
			System.out.println("\n\nEmployee "+(i+1)+"\n");
			staff[i].printdata();
		}
	}
}
			
