package threads;

public class threadinterface implements Runnable {

	@Override
	public void run() {
		System.out.println("U Entered Runnable state");
		
	}

	public static void main(String[] args){
		threadinterface ti=new threadinterface();
		Thread t=new Thread(ti);
		t.start();
	}
}
