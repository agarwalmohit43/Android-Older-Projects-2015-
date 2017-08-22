import java.lang.*;
class num5 extends Exception
{
	num5(int w){
		System.out.println(w+"\t is an illegal exception");
	}
}
public class userdefinedexce {
	public static void main(String[] args){
		
		counter(1);
	}

	public static void trial(int l) throws num5{
		if(l==5){
			throw new num5(1);
			
		}
	}

public static void counter(int i){
	try{
		for(int k=i;k<10;k++)
		{
			System.out.println(k);
			trial(k);
		}}catch(num5 e){
			System.out.println("\t Exception caught:"+e);
			
		}
	}



}







