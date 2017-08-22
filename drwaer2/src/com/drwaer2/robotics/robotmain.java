package com.drwaer2.robotics;

import com.drwaer2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class robotmain extends Activity implements OnItemSelectedListener {
	Spinner robotmain, roconstru;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.robotmain);
		robotmain = (Spinner) findViewById(R.id.robotmain);
		roconstru = (Spinner) findViewById(R.id.roconstru);

		ArrayAdapter robotmains = ArrayAdapter.createFromResource(this,
				R.array.rovers, android.R.layout.simple_dropdown_item_1line);
		robotmain.setAdapter(robotmains);

		ArrayAdapter rocons = ArrayAdapter.createFromResource(this,
				R.array.roconstru, android.R.layout.simple_dropdown_item_1line);
		roconstru.setAdapter(rocons);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		robotmain.setOnItemSelectedListener(this);
		roconstru.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

				roconstru.setVisibility(View.VISIBLE);
			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			this.onBackPressed();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = null;
		switch (position) {
		case 1:
			intent = new Intent(robotmain.this, roconstru.class);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(robotmain.this, rocombat.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		case 3:
			intent = new Intent(robotmain.this, roblitz.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		case 4:
			intent = new Intent(robotmain.this, ronavigator.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		case 5:
			intent = new Intent(robotmain.this, roterrance.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		case 6:
			intent = new Intent(robotmain.this, rosoccer.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		case 7:
			intent = new Intent(robotmain.this, rosplash.class);
			startActivity(intent);
			roconstru.setVisibility(view.GONE);
			break;
		}
		robotmain.setSelection(0);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
