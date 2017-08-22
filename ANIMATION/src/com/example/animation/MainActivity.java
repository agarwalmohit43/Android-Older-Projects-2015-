package com.example.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	ImageView iv;
	AnimationDrawable anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.imageView1);
		iv.setBackgroundResource(R.animator.animation);
		iv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		 anim=(AnimationDrawable) iv.getBackground();
		anim.start();
		
	}

}
