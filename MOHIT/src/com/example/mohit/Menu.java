package com.example.mohit;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[]={"MainActivity","TextPlay","Email","Camera","Data",
			 "GFx","GFXSurface","SoundStuff","Slider","Tabs"
			 ,"SimpleBrowser","Flipper","SharedPrefs","InternalData"
			 ,"ExternalData","SQLiteExample","Accelerate","HttpExample","GLExample"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1, classes));
	
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String sample=classes[position];
		try{
		Class ob=Class.forName("com.example.mohit."+sample);
		Intent navigate=new Intent(Menu.this,ob);
		startActivity(navigate);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater muu= getMenuInflater();
		muu.inflate(R.menu.cool_menu, menu);
		return true;
		
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutus:
			Intent about=new Intent(Menu.this,AboutUs.class);
			startActivity(about);
			
			break;
		case R.id.pre:
			Intent pre=new Intent(Menu.this,Prefs.class);
			startActivity(pre);
			break;
		case R.id.exit:finish();
			break;
		case R.id.ma:Intent a=new Intent(Menu.this,hehhehe.class);
		startActivity(a);
		break;
		}
		return false;
	}

	

}
