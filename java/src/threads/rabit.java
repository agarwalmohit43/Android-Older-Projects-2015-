package threads;

public class rabit implements Runnable{

	@Override
	public void run() {
		System.out.println("Rabbit is running");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
