package world.hhhh;

class cons{

	 double a,b;
	public cons(double a,double b)
	{
		this.a=a;
		this.b=b;
	}
	 cons(cons c)
	{
		System.out.println("copy constructor");
		a=c.a;
		b=c.b;
	}
	/*  public String toString() 
	  {
	        return "(" + a + " + " + b + "i)";
	    }*/
}
public class aaaa
{

	public static void main(String[] args)
	{
		cons ob=new cons(10,20);
		cons a=new cons(ob);
		cons ob2=a;
		System.out.println(a);
	}
}