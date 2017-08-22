package world.hhhh;


class a{
	/*final*/ public void fun(){
		System.out.println("class a");
		
	}}
	class b extends a{
		public void  fun(){
			System.out.println("class b");
		}
	}


public class objectpassing {

	public static void main(String[] args)
	{
		a ob=new b();
		ob.fun();
	}
}
