import java.util.BitSet;
public class bitset {
public static void main(String[] args){
	
	BitSet bitset1=new BitSet(16);
	BitSet bitset2=new BitSet(16);
	for(int i=0;i<16;i++){
		if((i%2)==0)bitset1.set(i);
		if((i%5)!=0)bitset2.set(i);
	}

	 System.out.println("Initial pattern in bits1: ");
     System.out.println(bitset1);
     System.out.println("\nInitial pattern in bits2: ");
     System.out.println(bitset2);
     
     bitset2.and(bitset1);
     System.out.println("\nbits2 AND bits1: ");
     System.out.println(bitset2);
     
     bitset2.or(bitset1);
     System.out.println("\nbits2 OR bits1: ");
     System.out.println(bitset2);
     
     bitset2.xor(bitset1);
     System.out.println("\nbits2 XOR bits1: ");
     System.out.println(bitset2);
}
}
