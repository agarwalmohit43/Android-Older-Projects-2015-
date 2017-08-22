package com.drwaer2;

import com.drwaer2.proficiency.arcania;
import com.drwaer2.proficiency.omegatrix;
import com.drwaer2.proficiency.promain;
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

public class brainteaser extends Activity implements OnItemSelectedListener {

	Spinner sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brainteasermain);
		sp = (Spinner) findViewById(R.id.brainteserspinner);

		ArrayAdapter spp = ArrayAdapter.createFromResource(this, R.array.brainteaser,
				android.R.layout.simple_dropdown_item_1line);
		sp.setAdapter(spp);
		
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		sp.setOnItemSelectedListener(this);

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
		Intent intent=null;
		switch(position){
		case 1:
			intent=new Intent(this,arcania.class);
			startActivity(intent);
			break;
		case 2:
			intent=new Intent(this,omegatrix.class);
			startActivity(intent);
			break;
			
		case 3:
			intent=new Intent(this,programming.class);
			startActivity(intent);
			break;
		}
		sp.setSelection(0);
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
