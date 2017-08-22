package com.example.fragmentcommunication;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements Communicator {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void responddata(String data) {

		FragmentManager fman=getFragmentManager();
		FragmentB ff=(FragmentB) fman.findFragmentById(R.id.fragment2);
		ff.changetext(data);
	}

	
}
