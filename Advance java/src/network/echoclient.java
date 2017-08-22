package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class echoclient {
	public static void main(String[] args) throws Exception {
		Socket s=null;
		PrintWriter output=null;
		BufferedReader br=null;
		
		try{
			s=new Socket("127.0.0.1",10007);
			output=new PrintWriter(s.getOutputStream(),true);
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		BufferedReader ip=new BufferedReader(new InputStreamReader(System.in));
		String userip;
		while((userip=ip.readLine())!=null){
			output.println(userip);
			System.out.println("echo: "+ip.readLine());

		}
		output.close();
		s.close();
		ip.close();
		br.close();
		
		
	}

}
