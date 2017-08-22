import java.awt.Frame;
import java.awt.Label;
public class howdywindow extends Frame {
public static void main(String[] args){
	
	new howdywindow();
}
howdywindow(){
	Label label;
	label=new Label("MOHIT");
	add(label);
	pack();
	show();
}
}
