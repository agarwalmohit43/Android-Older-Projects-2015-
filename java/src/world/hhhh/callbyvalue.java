package world.hhhh;


public class callbyvalue {

	int x,y;
	void swap(int a,int b){
		this.x=a;
		this.y=b;
		System.out.println("Swaaped Values before swapping: x= "+x+" y= "+y);

		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println("Swaaped Values After swapping: x= "+x+" y= "+y);
		
	}
	
}

