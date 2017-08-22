package com.example.preferenceactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		Intent i=new Intent(MainActivity.this,prefs.class);
		startActivity(i);		
		
	}

}
