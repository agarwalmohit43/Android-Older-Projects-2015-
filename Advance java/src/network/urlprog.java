package network;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class urlprog {

	
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://www.infiniteskills.com");
		System.out.println("Basic Info:");
		System.out.println();
		System.out.println("Protocol: "+url.getProtocol());
		System.out.println("Port: "+url.getPort());
		System.out.println("Host:"+url.getHost());
		URLConnection conn=url.openConnection();
		//check the content
		int contentlength=conn.getContentLength();
		int c;
		if(contentlength!=0){
			System.out.println("Content:");
			System.out.println();
			InputStream urlip=conn.getInputStream();
			while((c=urlip.read())!=-1){
				System.out.print((char)c);

			}
			urlip.close();

		}else{
			System.out.println("no content");

		}
		
	}
	

}
