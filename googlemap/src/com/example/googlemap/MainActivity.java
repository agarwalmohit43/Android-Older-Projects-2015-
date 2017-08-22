package com.example.googlemap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends Activity implements OnMapReadyCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		MapFragment mapFragment = (MapFragment) getFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);

	}

	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub
		map.setMyLocationEnabled(true);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.mapme, menu);
		MenuInflater muu = getMenuInflater();
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.simple:

			Intent ii = new Intent(MainActivity.this, simples.class);
			startActivity(ii);
			break;
		case R.id.menuforward:
			Intent i2 = new Intent(MainActivity.this, in.class);
			startActivity(i2);
			break;
		case R.id.menurefersh:
			Intent i3 = new Intent(MainActivity.this, cs.class);
			startActivity(i3);
			break;
		case R.id.menuhistory:
			Intent i4 = new Intent(MainActivity.this, FM.class);
			startActivity(i4);
			break;
		case R.id.menuhis:
			Intent i5 = new Intent(MainActivity.this, pl.class);
			startActivity(i5);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
