package com.example.networkaccess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	EditText et;
	Button b;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText1);
		b = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.textView1);
		b.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		try {
			URL url = null;
			url = new URL(et.getText().toString());
			URLConnection conn = url.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line="";
			while((line=br.readLine())!=null)
			{
				tv.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
