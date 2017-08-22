package cal;

interface aa{
	void a();
	void b();
	void c();
	void d();
}

abstract class bb implements aa{
	public void a() {
		System.out.println("hello");
	}
	public void b() {
		System.out.println("hellos");
	}
	public void c() {
		System.out.println("hellos");
	}
}

 class cc extends bb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void d() {
		System.out.println("hellod");		
	}
	public void a() {
		System.out.println("helloa");
	}
	public void b() {
		System.out.println("hellob");
	}
	public void c() {
		System.out.println("helloc");
	}

}
public class abstractinterface{
	public static void main(String...strings ){
		aa ob=new cc();
		ob.a();
		ob.b();
		ob.c();
		ob.d();
	}
}


