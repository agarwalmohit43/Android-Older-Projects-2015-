package confuse;

class C {
	
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

	class B {
		C pointa;
		
		public C getPointa() {
			return pointa;
		}
		public void setPointa(C pointa) {
			this.pointa = pointa;
		}
		public void draw(){
			System.out.println("Point A=("+getPointa().getX()+", "+getPointa().getY()+")");
		}
	}
	
public class object {

	public static void main(String[] args) {

		B ob=new B();
		C obb=new C();
		obb.setX(20);
		obb.setY(200);
		ob.setPointa(obb);
		ob.draw();
	}

}
