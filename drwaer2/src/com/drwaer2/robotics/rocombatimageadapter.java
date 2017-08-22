package com.drwaer2.robotics;

import com.drwaer2.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

public class rocombatimageadapter extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageslidemain);
		ViewPager views=(ViewPager) findViewById(R.id.imageviewpager);
		rocombatimageadap img=new rocombatimageadap(this);
		views.setAdapter(img);
		
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

		public boolean onOptionsItemSelected(MenuItem item) {

			 switch (item.getItemId()) {
	       case android.R.id.home:
	      	 this.onBackPressed();
	           }
			return super.onOptionsItemSelected(item);
		}
}
