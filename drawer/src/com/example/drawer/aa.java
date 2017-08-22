package com.example.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class aa extends Activity {

	TextView tv;
	int counter = 0;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.counter);
		tv = (TextView) findViewById(R.id.countertv);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		counter++;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("count", counter);
		tv.setText(counter);

	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);

		int c = savedInstanceState.getInt("count");
		tv.setText(c);
	}
}
