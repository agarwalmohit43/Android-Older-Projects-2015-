package com.example.internetbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


public class splash extends Activity {

	
	private static int SPLASH_TIME_OUT = 5000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash);
		Toast.makeText(getApplicationContext(), "INTERNET BROWSER BY MOHIT",
				   Toast.LENGTH_LONG).show();
		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				
				
                Intent i = new Intent(splash.this, MainActivity.class);
                splash.this.startActivity(i);
 
               
                splash.this.finish();
            }
        }, SPLASH_TIME_OUT);
		}
		
	}
	
	


