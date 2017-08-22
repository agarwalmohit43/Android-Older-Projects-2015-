package com.example.fragmentexamples;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Myfragment frag=new Myfragment();
		android.app.FragmentManager manager=getFragmentManager();
		android.app.FragmentTransaction trans=manager.beginTransaction();
		trans.add(R.id.rlayout,frag,"mohit");
		trans.commit();
		
	}

	
}
