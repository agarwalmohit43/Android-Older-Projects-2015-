import java.lang.*;
import java.util.Scanner;
class Employee
{
	private String name,address;
	private int id,salary;
	public Employee(String n,String a,int i,int s)
	{
		name=n;
		address=a;
		id=i;
		salary=s;
	}
	public void printdata()
	{
		System.out.println("Name : "+name);
		System.out.println("ID : "+id);
		System.out.println("Address : "+address);
		System.out.println("Salary : "+salary);
	}
}
