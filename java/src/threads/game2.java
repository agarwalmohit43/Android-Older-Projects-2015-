package threads;

public class game2 implements Runnable {

	public static void main(String[] args) {
		game2 g=new game2();
		Thread t=new Thread(g);
		t.start();
		
		
	}

	
	public void run() {
		
		rabit r=new rabit();
		Tortise to=new Tortise();
		Thread t1=new Thread(r);
		Thread t2=new Thread(to);
		t1.start();
		try {
			t1.join(500);
			t2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
