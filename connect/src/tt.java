import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
public class tt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fi=null;
		try{
			
			Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","loverboy43");
			DatabaseMetaData md=mycon.getMetaData();
			PreparedStatement ps=mycon.prepareStatement("update user set image=? where userid=2");
			System.out.println(""+md.getDriverName());
			System.out.println(""+md.getDatabaseProductVersion());

			File f=new File("C:\\Users\\MOHIT AGARWAL\\Downloads\\extra\\m.jpg");
			fi=new FileInputStream(f);		
			ps.setBinaryStream(1,fi);
		ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
