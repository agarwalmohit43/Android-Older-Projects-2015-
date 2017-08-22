package com.example.imageslide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class one extends Activity implements OnClickListener {
	
	Button ones,two;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ones=(Button) findViewById(R.id.oneone);
		two=(Button) findViewById(R.id.onetwo);
		ones.setOnClickListener(this);
		two.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {

		switch(v.getId()){
		
		case R.id.oneone:
			Intent intent=new Intent(this,ImageAdapter.class);
			intent.putExtra("first","one");
			startActivity(intent);
			break;
		case R.id.onetwo:
			Intent intents=new Intent(this,ImageAdapter.class);
			intents.putExtra("second","second");
			startActivity(intents);
			break;
		}
		
	}
}
