
import java.io.*;
public class constru {
	
	String name;
	int reg;
	int m1,m2;
	constru(){
		name="john";
		reg=12345;
		m1=50;
		m2=80;
		
	}
	constru(String n,int r,int mm,int nn){
		name=n;
		reg=r;
		m1=mm;
		m2=nn;
	}
	constru(constru s){
		name=s.name;
		reg=s.reg;
		m1=s.m1;
		m2=s.m2;
		
	}
	void display(){
		System.out.println(name+" "+reg+" "+m1+" "+m2);
	}
	
	public static void main(String args[])
	{
		constru a=new constru();
		constru b=new constru("john",123456,80,90);
		constru c=new constru(a);
		a.display();
		b.display();
		c.display();
		
	}
	

}
