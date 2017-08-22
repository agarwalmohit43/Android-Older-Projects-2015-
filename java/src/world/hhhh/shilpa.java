package world.hhhh;

public class shilpa {

	public static void main(String[] args) {
		String s="(Sh(ilp)a)";
		String a[]=s.split("0");
		System.out.print(a[0]);
		
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				count++;
			}else if(s.charAt(i)==')')
			{
				count--;
			}
			
			
				
		}
		if(count==0){
			System.out.print("equla");
			
		}else{
			System.out.print("new");
		}
	}

}
