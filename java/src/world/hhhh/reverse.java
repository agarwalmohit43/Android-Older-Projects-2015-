package world.hhhh;

public class reverse {

	public static void main(String[] args)
	{
		int a=123;int r=0;
		while(a>0){
			int x=a%10;
			r=r*10+x;
			a=a/10;
		}
		System.out.println(r);
	}
}
