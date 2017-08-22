import java.util.*;
public class ARRAYLISTS {

	public static void main(String[] args)
	{
		
		ArrayList<String> al=new ArrayList<String>();
		List<Integer> l=new ArrayList<>();
		l.add(5);
		l.add(2);
		String a=new String("MOHIT");
		al.add(a);
		System.out.println("contents of al: "+al);
		System.out.println("contents of l: "+l);
		int aa=l.size();
		for(int i=0;i<aa;i++){
			System.out.println(l.get(i));
		}
		String b=new String("KUMAR");
		al.add(b);
		System.out.println("contents of al: "+al);
		
		al.add("m");
		System.out.println("contents of al: "+al);
		al.add(2,"AGARWAL");
		System.out.println("contents of al: "+al);
		al.remove("m");
		System.out.println("contents of al: "+al);
		boolean isIn=al.contains(b);
		System.out.println("contains : "+isIn);
		int aaaa=5;
		String aaaaa=""+aaaa;
		al.add(aaaaa);
		System.out.println("contents of al: "+al);
		
	}
	
	
}
