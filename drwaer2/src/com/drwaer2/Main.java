package com.drwaer2;

import com.drwaer2.robotics.*;
import com.drwaer2.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ActionBar.OnNavigationListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnItemClickListener {
	DrawerLayout dw;
	ListView lv;
	private ActionBarDrawerToggle ad;
	private MyAdapter myadapter;
	String[] actions;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.lv);
		myadapter = new MyAdapter(Main.this);
		lv.setAdapter(myadapter);
		lv.setOnItemClickListener(this);
		
		dw = (DrawerLayout) findViewById(R.id.dr);
		
		
		ViewPager mainpage = (ViewPager) findViewById(R.id.mainpager);
		mainpageradap mainadap = new mainpageradap(this);
		mainpage.setAdapter(mainadap);

		// dialog
		// AlertDialog.Builder bus = new AlertDialog.Builder(Main.this);
		// bus.setMessage("THIS APPLICATION IS FOR DEMO PURPOSE DO U WISH TO CONTINUE & IT HAS GOT TERMS AND CONDITIONS");
		// bus.setCancelable(false);
		// bus.setPositiveButton("DECLINE", new
		// DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// Main.this.finish();
		// }
		// });
		// bus.setNegativeButton("I ACCEPT",
		// new DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// dialog.cancel();
		// }
		// });
		// AlertDialog alert = bus.create();
		// alert.show();

		// spineer on actionbar
		actions = getResources().getStringArray(R.array.act);
		ArrayAdapter<String> actionadap = new ArrayAdapter<String>(
				getBaseContext(),
				android.R.layout.simple_spinner_dropdown_item, actions);
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition,
					long itemId) {
				Intent intent = null;
				switch (itemPosition) {
				case 1:

					Intent sin = new Intent(Main.this,
							com.drwaer2.robotics.robotmain.class);
					startActivity(sin);

					break;
				case 2:

					Intent i = new Intent(Main.this, gaming.class);
					startActivity(i);
					break;
				case 3:
					intent = new Intent(Main.this, brainteaser.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(Main.this,
							com.drwaer2.creativity.createmain.class);
					startActivity(intent);

					break;
				
				

				case 5:
					intent = new Intent(Main.this, technical.class);
					startActivity(intent);

					break;

				}
				getActionBar().setSelectedNavigationItem(0);

				return false;
			}
		};
		getActionBar().setListNavigationCallbacks(actionadap,
				navigationListener);

		ad = new ActionBarDrawerToggle(this, dw, R.drawable.dr,
				R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				// Toast.makeText(Main.this, "Drawer opened",
				// Toast.LENGTH_SHORT)
				// .show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// Toast.makeText(Main.this, "Drawer closed",
				// Toast.LENGTH_SHORT)
				// .show();
			}
		};
		dw.setDrawerListener(ad);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("TECHSTORM 2.15");
	}

	// backoption
	public void onBackPressed() {
		// TODO Auto-generated method stub
		// super.onBackPressed();

		AlertDialog.Builder bu = new AlertDialog.Builder(Main.this);
		bu.setMessage("ARE YOU SURE WANT TO EXIT");
		bu.setCancelable(false);
		bu.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Main.this.finish();
			}
		});
		bu.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		AlertDialog alert = bu.create();
		alert.show();

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = null, chooser = null;
		switch (position) {
		case 0:
			intent = new Intent(android.content.Intent.ACTION_VIEW);
			intent.setData(Uri
					.parse("geo:22.630906200000000000,88.436148000000000000"));
			startActivity(intent);
			
			dw.closeDrawers();
			break;
		case 1:
			String url = "http://techstorm2015.in/";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			dw.closeDrawers();

			break;
		case 2:
			String urls = "https://www.facebook.com/techstorm2k15?ref=br_tf";
			Intent is = new Intent(Intent.ACTION_VIEW);
			is.setData(Uri.parse(urls));
			startActivity(is);
			break;
		case 3:
			intent = new Intent(Main.this, help.class);
			startActivity(intent);
			dw.closeDrawers();

			break;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		ad.syncState();
	}

	public void selectItem(int position) {
		lv.setItemChecked(position, true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (ad.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		ad.onConfigurationChanged(newConfig);
	}

}

class MyAdapter extends BaseAdapter {
	private Context context;
	String[] socials;
	int[] images = { R.drawable.college, R.drawable.web, R.drawable.facebook,
			R.drawable.help };

	public MyAdapter(Context context) {
		this.context = context;
		socials = context.getResources().getStringArray(R.array.socila);

	}

	@Override
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
	public View getView(int position, View convertView, ViewGroup viewgroup) {
		View row = null;
		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.custom_row, null);

		} else {
			row = convertView;
		}
		TextView tv1 = (TextView) row.findViewById(R.id.textView1);
		ImageView iv1 = (ImageView) row.findViewById(R.id.imageView1);

		tv1.setText(socials[position]);
		iv1.setImageResource(images[position]);
		return row;
	}

}

class mainpageradap extends PagerAdapter {

	Context context;
	private int[] image = { R.drawable.mains, R.drawable.bronchure2,
			R.drawable.bronchure3, R.drawable.brochureback };

	public mainpageradap(Context context) {
		this.context = context;
	}

	public int getCount() {
		return image.length;
	}

	public boolean isViewFromObject(View view, Object object) {
		return view == ((ImageView) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		ImageView img = new ImageView(context);
		img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		img.setImageResource(image[position]);
		((ViewPager) container).addView(img, 0);
		return img;
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}

}
