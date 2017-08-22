package com.drwaer2;


import com.drwaer2.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class splash extends Activity {
	private static int SPLASH_TIME_OUT = 3000;
	Button about;
	final Context context = this;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setTitle("TECHSTORM 2.15");
		setContentView(R.layout.splash);
		Toast.makeText(getApplicationContext(), "TECHSTORM 2.15",
				   Toast.LENGTH_LONG).show();
		about=(Button) findViewById(R.id.splashbutton);
		about.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final Dialog d=new Dialog(context);
				d.setContentView(R.layout.splashabout);
				d.setTitle("DEVELOPER");
				d.getWindow().setBackgroundDrawable(
						new ColorDrawable(android.graphics.Color.TRANSPARENT));
				TextView tvs = (TextView) d.findViewById(R.id.splashabout);
				tvs.setText(getString(R.string.mohit));
				tvs.setTextColor(Color.rgb(245,43,16));
				d.show();
				
			}
		});
		
new Handler().postDelayed(new Runnable() {
			
			public void run() {
				
				
                Intent i = new Intent(splash.this, Main.class);
                splash.this.startActivity(i);
 
               
                splash.this.finish();
            }
        }, SPLASH_TIME_OUT);
	}
}
