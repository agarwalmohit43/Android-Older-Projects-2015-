package com.example.customadapter;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class spinner extends Activity implements OnItemSelectedListener {

	Spinner sp, sp1, sp2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		sp = (Spinner) findViewById(R.id.spinner1);
		sp1 = (Spinner) findViewById(R.id.spinner2);
		sp2 = (Spinner) findViewById(R.id.spinner3);

		final String[] actions = getResources().getStringArray(R.array.act);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.days, android.R.layout.simple_dropdown_item_1line);

		ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,
				R.array.country, android.R.layout.simple_dropdown_item_1line);

		ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
				R.array.no, android.R.layout.simple_dropdown_item_1line);
		ArrayAdapter<String> actionadap = new ArrayAdapter<String>(
				getBaseContext(),
				android.R.layout.simple_spinner_dropdown_item, actions);
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		getActionBar().setTitle("welcome");

		ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition,
					long itemId) {

				switch (itemPosition) {
				case 1:
					Intent sin = new Intent(spinner.this, grid.class);
					startActivity(sin);
					break;

				}
				Toast.makeText(getBaseContext(),
						"You selected : " + actions[itemPosition],
						Toast.LENGTH_SHORT).show();
				return false;
			}
		};
		getActionBar().setListNavigationCallbacks(actionadap,
				navigationListener);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		sp.setAdapter(adapter);
		sp1.setAdapter(adapter1);
		sp2.setAdapter(adapter2);
		sp.setOnItemSelectedListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {

		TextView sptv = (TextView) view;
		Toast.makeText(this, "you selected " + sptv.getText(),
				Toast.LENGTH_SHORT).show();
		switch (position) {
		case 1:
			sp1.setVisibility(view.VISIBLE);
			sp2.setVisibility(view.GONE);

			break;
		case 2:
			sp2.setVisibility(view.VISIBLE);
			sp1.setVisibility(view.GONE);

			break;
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		 switch (item.getItemId()) {
         case android.R.id.home:
        	 this.onBackPressed();
             }
		 
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}
