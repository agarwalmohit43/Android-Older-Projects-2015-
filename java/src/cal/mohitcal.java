package cal;

public class mohitcal {

	public double c;
	public double d,e,f;
	public double q,w,div;
	public double t,y,mul;
	public double sum(double a,double b)
	{
		
		this.c=a+b;
		return c;
		
	}
	
	public double subtract(double a,double b)
	{
		
		
		if(a>b)
		{
			this.f=a-b;
			return f;
			
		}
		else {
			this.f=b-a;
			return f;
			
		}
		
		
	}
	
	public double mul(double a,double b){
		
		this.mul=a*b;
		return mul;
	}
	public double div(double a,double b)
	{try{
		
		
		this.div=a/b;
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	finally{
		return div;
	}
	}
	
	public void display(int s){
		switch(s)
		{
		case 1:System.out.println("Addition Result:"+c);
				break;
				
		case 2:System.out.println("Subtraction Result:"+f);
				break;
				
		case 3:System.out.println("Division Result:"+div);
				break;
		case 4:System.out.println("Multiplication result:"+mul);
				break;
				default:System.out.println("invalid choice");
		}
		
		
		
	}
	
	
}
