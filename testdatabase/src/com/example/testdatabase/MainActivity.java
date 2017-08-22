package com.example.testdatabase;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView resulttv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resulttv=(TextView) findViewById(R.id.result);
		StrictMode.enableDefaults();
		getData();
		
	}
	public void getData(){
		
		String result="";
		InputStream isr=null;
		try{
			
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost("http://mohit.gobusnepal.com/android/logintest.php");
			HttpResponse response=httpclient.execute(httppost);
			HttpEntity entity=response.getEntity();
			isr=entity.getContent();
		
		}catch(Exception e){
			android.util.Log.e("log..tag","error in http connection"+e.toString());
			resulttv.setText("Couldnot connect to database");
			
		}
		//convert response to string
		try{
			BufferedReader reader=new BufferedReader(new InputStreamReader(isr,"iso-8859-1"));
			StringBuilder sb=new StringBuilder();
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"\n");
		}isr.close();
		
		result=sb.toString();
		}catch(Exception e){
			android.util.Log.e("log..tag","error converting result"+e.toString());			
		}
		//parse json data
		try{
			String s="";
			JSONArray jArray=new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json=jArray.getJSONObject(i);
				s=s+
						"Userid : "+json.getString("uid")+"\n"+"Username : "+json.getString("uname")+"\n"+
						"Password : "+json.getString("pass")+"\n\n";
				
			}
			resulttv.setText(s);
			
		}catch(Exception e){
			android.util.Log.e("log..tag","error parsing data"+e.toString());
			
		}
	}

}
