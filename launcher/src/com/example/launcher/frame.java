package com.example.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.widget.CheckBox;
import android.widget.ImageView;

public class frame extends Activity implements OnClickListener, OnDragListener  {
	
	ImageView iv1,iv2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame);
		
		iv1=(ImageView) findViewById(R.id.imageView1);
		iv2=(ImageView) findViewById(R.id.imageView2);
		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv1.setOnDragListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.imageView1:
			iv1.setVisibility(View.GONE);
			iv2.setVisibility(View.VISIBLE);
			break;
		
		case R.id.imageView2:
			iv1.setVisibility(View.VISIBLE);
			iv2.setVisibility(View.GONE);
			break;
		}	
	}
	@Override
	public boolean onDrag(View v, DragEvent event) {

		
		
		return false;
	}

}
