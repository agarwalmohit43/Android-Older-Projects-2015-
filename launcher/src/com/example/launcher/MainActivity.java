package com.example.launcher;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.UriMatcher;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

	Button map, market, email, image, images,video;
CheckBox cb;ToggleButton tb;
ScrollView sv;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = (Button) findViewById(R.id.button1);
		video=(Button) findViewById(R.id.videoss);
		market = (Button) findViewById(R.id.button2);
		email = (Button) findViewById(R.id.button3);
		image = (Button) findViewById(R.id.button4);
		images = (Button) findViewById(R.id.button5);
		cb=(CheckBox) findViewById(R.id.checkBox1);
		tb=(ToggleButton) findViewById(R.id.toggleButton1);
		sv=(ScrollView) findViewById(R.id.sv);
		map.setOnClickListener(this);
		market.setOnClickListener(this);
		email.setOnClickListener(this);
		image.setOnClickListener(this);
		video.setOnClickListener(this);
		images.setOnClickListener(this);
		cb.setOnClickListener(this);
		tb.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {

//			CheckBox c=(CheckBox) v;
//			if(c.isChecked()){
//				Toast.makeText(this,"WOOOO",Toast.LENGTH_SHORT).show();
//			}else{
//				Toast.makeText(this,"awwwww",Toast.LENGTH_SHORT).show();
//
//			}
		if(cb.isChecked()){
		Toast.makeText(this,"WOOOO",Toast.LENGTH_SHORT).show();

		}else{
			Toast.makeText(this,"awwwww",Toast.LENGTH_SHORT).show();

		}
		Intent intent = null, chooser = null;
		switch (v.getId()) {
		case R.id.button1:
			intent = new Intent(android.content.Intent.ACTION_VIEW);
			intent.setData(Uri.parse("geo:22.630906200000000000,88.436148000000000000"));
			startActivity(intent);
			break;

		case R.id.button2:
			intent = new Intent(android.content.Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("market://details?id=com.facebook.katana&hl=en"));
			chooser = Intent.createChooser(intent, "Launch Market");
			startActivity(chooser);
			break;
		case R.id.button3:
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setData(Uri.parse("mailto:"));
			Uri imageS = Uri
					.parse("android.resource://com.example.launcher/drawable/"
							+ R.drawable.m);

			intent.putExtra(intent.EXTRA_STREAM, imageS);
			intent.setType("image/*");

			String[] to = { "agarwalmohit4448@yahoo.com" };
			intent.putExtra(intent.EXTRA_EMAIL, to);
			intent.putExtra(intent.EXTRA_SUBJECT,
					"MAIL BY LAUNCHER MOHIT KUMAR AGARWAL");
			intent.putExtra(intent.EXTRA_TEXT, "MY OWN CREATED EMAIL APP! :D");
			intent.setType("message/rfc822");
			chooser = intent.createChooser(intent, "MOHIT MAIL");
			startActivity(chooser);
			break;

		case R.id.button4:
			Toast toasts=new Toast(this); 
			ViewGroup vgs=(ViewGroup) findViewById(R.id.loutoast);

			View appears=getLayoutInflater().inflate(R.layout.toast_layout,vgs);
			toasts.setView(appears);
			toasts.setGravity(Gravity.CENTER,0,0);
			toasts.show();
			
			
			Uri image = Uri
					.parse("android.resource://com.example.launcher/drawable/"
							+ R.drawable.m);
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setType("image/*");
			intent.putExtra(intent.EXTRA_STREAM, image);
			intent.putExtra(intent.EXTRA_TEXT, "MOHIT AGARWAL");
			chooser = intent.createChooser(intent, "SEND IMAGE");
			startActivity(chooser);
			break;

		case R.id.button5:
//			Toast toast=new Toast(this); 
//			ViewGroup vg=(ViewGroup) findViewById(R.id.loutoast);
//
//			View appear=getLayoutInflater().inflate(R.layout.toast_layout,vg);
//			toast.setView(appear);
//			toast.setGravity(Gravity.CENTER,0,0);
//			toast.show();
//			intent=new Intent(MainActivity.this,frame.class);
//			startActivity(intent);
			
			
			File pictures=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			String[] picturelist=pictures.list();
			for(String pics:picturelist){
			Toast.makeText(this,pics,Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.videoss:
			Intent i=new Intent(MainActivity.this,video.class);
			startActivity(i);
			
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if(isChecked==true){
			sv.setBackgroundColor(Color.BLACK);
		}else{
			sv.setBackgroundColor(Color.CYAN);
		}
		
		
	}

}
