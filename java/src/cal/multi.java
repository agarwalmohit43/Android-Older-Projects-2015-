package cal;

interface a{
	abstract void run();
}

interface b{
	abstract void runs();
}

 class multi implements a,b{

	@Override
	public void run() {
		System.out.println("multi");
		
	}

	@Override
	public void runs() {
		System.out.println("multis");		
	}
public static void main(String...strings )
{
	multi ob=new multi();
	ob.run();
	ob.runs();
}
}
