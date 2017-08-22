package com.example.buttonanimation;

import com.example.buttonanimation.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	   }

	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }

	   public boolean onOptionsItemSelected(MenuItem item) 
	   { 
	   super.onOptionsItemSelected(item); 
	      switch(item.getItemId()) 
	      { 
	      case R.id.zoomInOut:
	         ImageView image = (ImageView)findViewById(R.id.imageView1);

	         Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
	         image.startAnimation(animation);
	            return true;
	      case R.id.rotate360:
	        ImageView image1 = (ImageView)findViewById(R.id.imageView1);

	        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
	         TranslateAnimation transAnimation= new TranslateAnimation(0, 200, 0, 0);
		        transAnimation.setDuration(5000);
	         image1.startAnimation(transAnimation);

	            return true;
	      case R.id.fadeInOut:
	        ImageView image2 = (ImageView)findViewById(R.id.imageView1);
	        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
	        image2.startAnimation(animation2);
	           return true;

	      case R.id.moves:
	    	  ImageView image22 = (ImageView)findViewById(R.id.imageView1);
		        Animation animation22 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
		        image22.startAnimation(animation22);
		        return true;

	      }
	      return false;
	   }

	}
