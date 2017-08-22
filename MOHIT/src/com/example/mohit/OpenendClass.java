package com.example.mohit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenendClass extends Activity implements OnClickListener,OnCheckedChangeListener{

	TextView ques,text;
	Button returndata;
	RadioGroup sl;
	String getbread,setdata;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.send);
		initialise();
		
//		Bundle gotbasket=getIntent().getExtras();
//		
//		 getbread=gotbasket.getString("key");
//		 ques.setText(getbread);
		
	}
	private void initialise() {
		// TODO Auto-generated method stub
		ques=(TextView)findViewById(R.id.tquestions);
		text=(TextView)findViewById(R.id.tvtext);
		sl=(RadioGroup)findViewById(R.id.ranswers);
		returndata=(Button)findViewById(R.id.bReturn);
		returndata.setOnClickListener(this);
		sl.setOnCheckedChangeListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person=new Intent();
		Bundle Backpack=new Bundle();
		Backpack.putString("answers", setdata);
		person.putExtras(Backpack);
		setResult(RESULT_OK,person);
		finish();
		
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		case R.id.rCrazy:
			setdata="Probably Right!";
			          break;
		case R.id.rsmart:
			setdata="Definitly Right!";
					break;
					
		case R.id.rboth:
			setdata="Spot On!";
						break;
		}
		text.setText(setdata);
	}
	
	

}
