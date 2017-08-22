package com.example.mohit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;

public class GetMethidEx extends Activity {

	public String getInternetData()throws Exception{
		BufferedReader i=null;
		String data=null;
		try{
			HttpClient client=new DefaultHttpClient();
			URI u=new URI("http://www.mybringback.com");
			HttpGet request=new HttpGet();
			request.setURI(u);
			HttpResponse response=client.execute(request);
			i=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb=new StringBuffer("");
			String l="";
			String nl=System.getProperty("line.separator");
			while((l=i.readLine())!=null){
				sb.append(l+nl);
			}
			i.close();
			data=sb.toString();
			return data;
		}finally{
			if(i!=null){
				try{
					i.close();
					return data;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
}
