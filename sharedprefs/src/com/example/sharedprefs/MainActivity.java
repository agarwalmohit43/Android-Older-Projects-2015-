package com.example.sharedprefs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText1);
		SharedPreferences setting = getSharedPreferences("MYFILE", 0);
		et.setText(setting.getString("tvalue", ""));

	}

	@Override
	protected void onStop() {
		
		super.onStop();
		SharedPreferences setting = getSharedPreferences("MYFILE", 0);
		SharedPreferences.Editor editt=setting.edit();
		editt.putString("tvalue",et.getText().toString());
		editt.commit();
	}
}
