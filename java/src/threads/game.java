package threads;

public class game implements Runnable {

	@Override
	public void run() {
		rabit r=new rabit();
		Tortise to=new Tortise();
		Thread t=new Thread(r);
		Thread t2=new Thread(to);

		t.start();
		t2.start();

		try {
			t.sleep(5000);
			System.out.println("Rabbit Sleeps Thinks Tortise is too slow");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After 5 seconds rabits wakes up and find tortise is too far and going to win the race");
		Thread t3=new Thread(r);
		t3.start();
		System.out.println("Unfortunately Tortise Wins the race");
		System.out.println("Slow and steady win the race");
		try {
			t.join(100);
			t2.join(100);
			t3.join(100);
			System.out.println("Tortise is the winner");

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		
		game g=new game();
		Thread t=new Thread(g);
		t.start();
		
		
	}

}
