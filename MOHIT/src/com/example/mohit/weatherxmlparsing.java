package com.example.mohit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class weatherxmlparsing extends Activity implements OnClickListener {

	static final String baseurl="http://www.google.com/ig/api?weather=";
	EditText city,state;
	TextView tv;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		city=(EditText) findViewById(R.id.cityname);
		state=(EditText) findViewById(R.id.statename);
		tv=(TextView) findViewById(R.id.cw);
		b=(Button) findViewById(R.id.checkweather);
		b.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		String c=city.getText().toString();
		String s=state.getText().toString();
		StringBuilder url=new StringBuilder(baseurl);
		
	}
}
