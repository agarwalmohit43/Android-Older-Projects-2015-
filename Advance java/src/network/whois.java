package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class whois {
	public static void main(String[] args) throws Exception{

		Socket s=new Socket("whois.internic.net",43);
		InputStream ip=s.getInputStream();
		OutputStream os=s.getOutputStream();
		String ss="infiniteskills.com\n";
		byte buffer[]=ss.getBytes();
		os.write(buffer);
		int ch;
		while((ch=ip.read())!=-1){
			System.out.print((char)ch);
		}
		s.close();
		
	}

}
