package com.example.customadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class mydialog extends Activity implements OnClickListener {
	Button b;
	ImageView gdiv2;
	TextView gdtv1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		b=(Button) findViewById(R.id.dialogbt1);
		gdiv2=(ImageView) findViewById(R.id.dialogiv1);
		gdtv1=(TextView) findViewById(R.id.dialogtv1);
		b.setOnClickListener(this);
		Intent intent=getIntent();
		if(intent!=null){
			int imageid=intent.getIntExtra("countryimage", R.drawable.flags1);
			
			String name=intent.getStringExtra("countryname");
			gdiv2.setImageResource(imageid);
			gdtv1.setText(name);
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
