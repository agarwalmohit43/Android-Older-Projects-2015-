package cal;

public class Stringas {

	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("MOhit");
		
		System.out.println(sb.append("HI"));
		System.out.println(sb.capacity());
		System.out.println(sb.charAt(2));
		System.out.println(sb.hashCode());
		System.out.println(sb.replace(1,2,"JIO"));
		
	}

}
