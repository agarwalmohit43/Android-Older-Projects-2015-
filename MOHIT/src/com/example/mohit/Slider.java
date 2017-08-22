package com.example.mohit;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnCheckedChangeListener, OnClickListener, OnDrawerOpenListener {
	SlidingDrawer sb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button handle1=(Button)findViewById(R.id.slb1);
		Button handle2=(Button)findViewById(R.id.slb2);
		Button handle3=(Button)findViewById(R.id.slb3);
		Button handle4=(Button)findViewById(R.id.slb4);
		sb=(SlidingDrawer)findViewById(R.id.drawer1);
		sb.setOnDrawerOpenListener(this);
		CheckBox cbox=(CheckBox)findViewById(R.id.slcb11);
		cbox.setOnCheckedChangeListener(this);
        handle1.setOnClickListener(this);
        handle2.setOnClickListener(this);
        handle3.setOnClickListener(this);
        handle4.setOnClickListener(this);

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.isChecked()){
			sb.lock();
		}else{
			sb.unlock();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.slb1:
			sb.open();
			
			break;
		case R.id.slb2:
			
			sb.lock();
			break;
		case R.id.slb3:
			sb.toggle();
			
			break;
		case R.id.slb4:
			
			sb.close();
			break;
			
		}
		
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp=MediaPlayer.create(this,R.raw.gun);
		mp.start();
		
	}
	
	

}
