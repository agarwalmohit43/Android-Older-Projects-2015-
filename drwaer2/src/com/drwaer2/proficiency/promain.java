package com.drwaer2.proficiency;

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

public class promain extends Activity implements OnItemSelectedListener {

	Spinner sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.promain);
		sp = (Spinner) findViewById(R.id.promainspinner);

		ArrayAdapter adapter = ArrayAdapter.createFromResource(
				getBaseContext(), R.array.profie,
				android.R.layout.simple_dropdown_item_1line);
		
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(this);
		
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
		Intent intent=null;
		switch(position){
		
		case 1:
			intent=new Intent(promain.this,arcania.class);
			startActivity(intent);
			break;
		case 2:
			intent=new Intent(promain.this,omegatrix.class);
			startActivity(intent);
			break;
		
		case 3:
			intent=new Intent(promain.this,ennovation.class);
			startActivity(intent);
			break;	
		case 4:
			intent=new Intent(promain.this,technomania.class);
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
