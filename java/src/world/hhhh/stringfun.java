package world.hhhh;

public class stringfun {

	public static void main(String[] args) {
		String b="(((hi)))";
		String e[]={"(",")","(",")","(",")"};
		int c=0,d=0,t=0,y=0;
		String a="MMOHITT";
		System.out.println(a.indexOf("M"));
		System.out.println(a.charAt(2));
		System.out.println(a.lastIndexOf("T"));
		System.out.println(a.toUpperCase());
		System.out.println(a.substring(0));
		int length=e.length;
		for(int i=0;i<length;i++)
		{
			if(e[i]=="("){
				c++;
				continue;
				
			}
		}
		for(int j=0;j<length;j++){
		
			if(e[j]==")"){
				d++;
				continue;
			}
		}

		for(int i=0;i<b.length();i++){
			if(b.charAt(i)=='('){
				t++;
				continue;
				
			}
		}
		
		for(int i=0;i<b.length();i++){
			if(b.charAt(i)==')'){
				y++;
				continue;
				
			}
		}
		
			
			if(c==d){
				System.out.println("(: "+c+"): "+d);
			}else{
				System.out.println("(: "+c+"): "+d);
			}
			
			if(t==y){
				System.out.println("(: "+t+"): "+y);
			}else{
				System.out.println("(: "+t+"): "+y);
			}
	}

}
