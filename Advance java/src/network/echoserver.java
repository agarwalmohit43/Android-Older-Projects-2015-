package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class echoserver {

	public static void main(String[] args)throws Exception {

		ServerSocket s=null;
		try{
			s=new ServerSocket(10007);
		}catch(Exception e){
			System.out.println("can't listen on 10007");

			e.printStackTrace();
		}
		Socket client=null;
		System.out.println("listining for connection...");
		try{
			client=s.accept();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("connected successfully");
		System.out.println("listining for input..");
		PrintWriter pw=new PrintWriter(client.getOutputStream(),true);
		BufferedReader ip=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String inputline;
		while((inputline=ip.readLine())!=null){
			
			System.out.println("Server:"+inputline);
			pw.println(inputline);
			if(inputline.equals("Bye")){
				break;
			}
			ip.close();
			pw.close();
			client.close();
			s.close();

			
		}
		


	}

}
