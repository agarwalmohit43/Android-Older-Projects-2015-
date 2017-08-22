package com.example.progressdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button b,h,cs;
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cs=(Button) findViewById(R.id.button3);
		cs.setOnClickListener(this);
		h=(Button) findViewById(R.id.button2);
		h.setOnClickListener(this);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
switch(v.getId()){
case R.id.button1:
	pd=new ProgressDialog(MainActivity.this);
	pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	pd.setCancelable(true);
	pd.setMessage("Just wait..");
	pd.setIndeterminate(true);
	pd.show();
	break;
case R.id.button2:
	pd=new ProgressDialog(MainActivity.this);
	pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	pd.setCancelable(true);
	pd.setMessage("Just wait..");
	pd.setIndeterminate(false);
	pd.show();
	pd.setProgress(50);
	break;
case R.id.button3:
	Dialog d=new Dialog(MainActivity.this);
	d.setContentView(R.layout.dialog);
	d.setTitle("custom Dialog by MOHIT!");
	d.show();
	break;
	
}
		
	}

	
}
