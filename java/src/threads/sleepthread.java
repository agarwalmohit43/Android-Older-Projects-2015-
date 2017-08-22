package threads;

class sleepthread extends Thread{  
 public void run(){  
  for(int i=1;i<5;i++)
  {  
	    try{
	    	Thread.sleep(1000);
	    	}
	    catch(InterruptedException e)
	    		{
	    		System.out.println(e);
	    		}  
	    			System.out.println(i);  
  }  
 }  
 public static void main(String args[]){  
  sleepthread t1=new sleepthread();  
  sleepthread t2=new sleepthread();  
   
  t1.start();  
  t2.start();  
 }  
}