package com.example.progresssbar;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private static int SPLASH_TIME_OUT = 5000;

	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
new Handler().postDelayed(new Runnable() {
		
		public void run() {
			
			
            Intent i = new Intent(MainActivity.this, mohit.class);
            MainActivity.this.startActivity(i);

           
            MainActivity.this.finish();
        }
    }, SPLASH_TIME_OUT);
	}
}

	

