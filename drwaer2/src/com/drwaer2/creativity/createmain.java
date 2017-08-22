package com.drwaer2.creativity;

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

public class createmain extends Activity implements OnItemSelectedListener {
	Spinner main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.creativitymain);
		main = (Spinner) findViewById(R.id.createspinner);

		ArrayAdapter create = ArrayAdapter
				.createFromResource(this, R.array.creativity,
						android.R.layout.simple_dropdown_item_1line);
		main.setAdapter(create);
		main.setOnItemSelectedListener(this);

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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = null;
		switch (position) {

		case 1:
			intent = new Intent(createmain.this, mmlive.class);
			startActivity(intent);
			main.setSelection(0);

			break;
		case 2:
			intent = new Intent(createmain.this, passionwithreels.class);
			startActivity(intent);
			main.setSelection(0);

			break;
		case 3:
			intent = new Intent(createmain.this, theuntoldsrotry.class);
			startActivity(intent);
			main.setSelection(0);

			break;
		case 4:
			intent = new Intent(createmain.this, spotlight.class);
			startActivity(intent);
			main.setSelection(0);

			break;
		case 5:
			intent = new Intent(createmain.this, art.class);
			startActivity(intent);
			main.setSelection(0);

			break;

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}
