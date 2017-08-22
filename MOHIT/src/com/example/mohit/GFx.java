package com.example.mohit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFx extends Activity  {

	WakeLock wl;

	Loverboy ourview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		PowerManager pM=(PowerManager)getSystemService(Context.POWER_SERVICE);
		wl=pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "hi");
		
		
		
		super.onCreate(savedInstanceState);
		wl.acquire();
		ourview=new Loverboy(this);
		setContentView(ourview);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}
	
	

}
