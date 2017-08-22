package threads;

public class threadclass extends Thread {
	
	public void run(){
		System.out.println("Thread is running");
	}


	public static void main(String[] args) {
		
		threadclass t=new threadclass();
		t.start();

	}

}
