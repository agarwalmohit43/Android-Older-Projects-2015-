package com.example.tween;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Animation anim=AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation);
		b.startAnimation(anim);
		
	}

	
}
