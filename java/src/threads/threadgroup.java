package threads;

public class threadgroup implements Runnable {

	public static void main(String[] args) {
		threadgroup ob=new threadgroup();
    ThreadGroup tg=new ThreadGroup("Mohit Thread");
    Thread t1=new Thread(tg, ob, "one");
    Thread t2=new Thread(tg, ob, "two");
    Thread t3=new Thread(tg, ob, "three");
    
    t1.start();
    t2.start();
    t3.start();
    
    System.out.println("\nThread Group Name: "+tg.getName());
    
    tg.list();

		
		
	}

	
	public void run() {
		
		System.out.println("Current Running Thread Name: "+Thread.currentThread().getName());
		
	}

}
