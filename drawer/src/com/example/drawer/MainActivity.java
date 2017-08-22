package com.example.drawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	DrawerLayout dw;
	ListView lv;
	private ActionBarDrawerToggle ad;
	private MyAdapter myadapter;
	Spinner sp;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		sp=(Spinner) findViewById(R.id.spinner1);
		lv = (ListView) findViewById(R.id.lv);
		myadapter=new MyAdapter(MainActivity.this);
		lv.setAdapter(myadapter);

		lv.setOnItemClickListener(this);
		dw = (DrawerLayout) findViewById(R.id.dr);
		
		ad = new ActionBarDrawerToggle(this, dw, R.drawable.dr,
				R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				Toast.makeText(MainActivity.this, "Drawer opened",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				Toast.makeText(MainActivity.this, "Drawer closed",
						Toast.LENGTH_SHORT).show();
			}
		};
		dw.setDrawerListener(ad);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		ad.syncState();
	}

	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		ad.onConfigurationChanged(newConfig);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		switch(position){
		case 0: Intent i=new Intent(MainActivity.this,aa.class);
				startActivity(i);
				break;
		}
		selectItem(position);
	}

	public void selectItem(int position) {
		lv.setItemChecked(position, true);

	}

	public void setTitle(String title) {
		getActionBar().setTitle(title);
	}
	

}

class MyAdapter extends BaseAdapter {
	private Context context;
	String[] socials;
	int[] images = { R.drawable.ic_fb, R.drawable.ic_gp, R.drawable.ic_wp,
			R.drawable.ic_yt };

	public MyAdapter(Context context) {
		this.context = context;
		socials = context.getResources().getStringArray(R.array.socila);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return socials.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return socials[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row=null;
		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(R.layout.custom_row,null);
			
		} else {
			row=convertView;
		}
		TextView tv1=(TextView) row.findViewById(R.id.textView1);
		ImageView iv1=(ImageView) row.findViewById(R.id.imageView1);
		
		tv1.setText(socials[position]);
		iv1.setImageResource(images[position]);
		return row;
	}

}
