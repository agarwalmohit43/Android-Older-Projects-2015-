import java.util.*;
public class discountcalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		System.out.println("Enter the amount");
		int amount=in.nextInt();
		System.out.println("Enter the discount");
		int dis=in.nextInt();
		
		//double disamount=amount*((double)dis/100);
		double disamount=(amount*dis)/100;

		double total=amount-disamount;
		System.out.println(total);



		
		
	}

}
