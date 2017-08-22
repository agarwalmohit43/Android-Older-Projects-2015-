package threads;

class one {
	synchronized void print(int n){
		for(int i=0;i<=5;i++){
			System.out.println(n*i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class two extends Thread{
	one ob;
	two(one ob){
		this.ob=ob;
	}
	
	public void run(){
		ob.print(5);
	}
}
class three extends Thread{
	one ob;
	three(one ob){
		this.ob=ob;
	}
	
	public void run(){
		ob.print(100);
	}
}




public class Synchronisationblock {
	
	public static void main(String[] args){
		one obj=new one();
		two t1=new two(obj);
		three t2=new three(obj);
		t1.start();
		t2.start();
	}
	

}
