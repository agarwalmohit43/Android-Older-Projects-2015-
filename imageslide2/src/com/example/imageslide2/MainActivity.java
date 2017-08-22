package com.example.imageslide2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	ViewPager viewpager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager=(ViewPager) findViewById(R.id.pager);
		PagerAdapter pad=new PageAdapter(getSupportFragmentManager());
		viewpager.setAdapter(pad);
	}

}
