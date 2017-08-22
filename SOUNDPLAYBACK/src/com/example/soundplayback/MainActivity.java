package com.example.soundplayback;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
		MediaPlayer mp=MediaPlayer.create(MainActivity.this,R.raw.beep);
		mp.start();
		Intent i=new Intent(MainActivity.this,media.class);
		startActivity(i);
		
	}


}
