package com.alphabetlearning;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Intent;

public class MainActivity extends Activity {


		ProgressBar p;
		int p1;
		 final int totalProgressTime = 100;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			p=(ProgressBar)findViewById(R.id.progressBar1); 

	            final Thread t = new Thread(){
	            public void run(){
	          
	               int jumpTime = 0;
	               while(jumpTime < totalProgressTime)
	               {
	                  try 
	                  {
	                     sleep(200);
	                     jumpTime += 5;
	                     p.setProgress(jumpTime);
	                  } catch (InterruptedException e) 
	                  {
	                    e.printStackTrace();
	                  }
	               }
	               Intent i=new Intent(getApplicationContext(),Alphalisdraw.class);
	               startActivity(i);

	            }
	            };
	            t.start();
			
		}

		
	}

