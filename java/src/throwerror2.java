
public class throwerror2 {

	public static double add(double a,double b)throws ArithmeticException{
		double c=a/b;
		if(c>0){
		return c;
		}else{
			throw new ArithmeticException();
			
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(add(50,5));
	}

}
