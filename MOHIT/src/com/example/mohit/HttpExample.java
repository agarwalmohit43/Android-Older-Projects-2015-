package com.example.mohit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpExample extends Activity {

	TextView tv;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		tv=(TextView) findViewById(R.id.http);
		GetMethidEx gm=new GetMethidEx();
		String returned;
		try {
			returned = gm.getInternetData();
			tv.setText(returned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
