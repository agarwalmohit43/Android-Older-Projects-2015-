package com.example.mohit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {

	EditText sharedata;
	TextView dataresult;
	SharedPreferences somedata;
	public static String filename="MyFile";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedprefs);
		initialise();
		somedata=getSharedPreferences(filename,0);

		
	}
	private void initialise() {
		// TODO Auto-generated method stub
		Button save=(Button)findViewById(R.id.shsave);
		Button load=(Button)findViewById(R.id.shload);
		sharedata=(EditText)findViewById(R.id.shet);
		dataresult=(TextView)findViewById(R.id.shtv);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.shsave:
			String data=sharedata.getText().toString();
			SharedPreferences.Editor editor=somedata.edit();
			editor.putString("sharedstring", data);
			editor.commit();
			break;
		case R.id.shload:
			somedata=getSharedPreferences(filename,0);
			String ldata=somedata.getString("sharedstring", "could't load data");
			dataresult.setText(ldata);
			break;
		}
		
	}

	
	
}
