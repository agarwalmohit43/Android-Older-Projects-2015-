package com.example.customadapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	// private Context context;

	ListView lv1;
	String[] days;// ={"SUNDAY","MONADAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	String[] desc;
	int[] images = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		days = getResources().getStringArray(R.array.days);
		lv1 = (ListView) findViewById(R.id.lv1);
		desc = getResources().getStringArray(R.array.no);

		// for only text view use this adapter
		// ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, days);

		// for image+textview
		// ArrayAdapter<String> ait = new ArrayAdapter<>(this,
		// R.layout.custom_row, R.id.textView1, days);
		// lv1.setAdapter(ait);
		// lv1.setOnItemClickListener(this);
		myadapter ad = new myadapter(this, days, images, desc);
		lv1.setAdapter(ad);
		lv1.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		switch(position){
		case 0:Intent grid=new Intent(MainActivity.this,grid.class);
				startActivity(grid);
			Toast.makeText(MainActivity.this,"GRID",Toast.LENGTH_SHORT).show();
				break;
		case 1:
			Intent spinner=new Intent(MainActivity.this,spinner.class);
			startActivity(spinner);
		Toast.makeText(MainActivity.this,"SPINNER",Toast.LENGTH_SHORT).show();
			break;
			
		}
	}

//	@Override
//	public void onItemClick(AdapterView<?> parent, View view, int position,
//			long id) {
//
//		
//		switch(position){
//		case 0: Toast.makeText(MainActivity.this,"Mohit",Toast.LENGTH_SHORT).show();
//				break;
//		}
//		
//	}

	}

	// for item selection on textview+textviewandimages
	// @Override
	// public void onItemClick(AdapterView<?> parent, View view, int position,
	// long id) {
	// TextView tv = (TextView) view;
	// Toast.makeText(this, tv.getText() + " " + position, Toast.LENGTH_SHORT)
	// .show();
	//
	// }




class MyHolder {
	ImageView iv;
	TextView tv1, tv2;

	MyHolder(View view) {
		iv = (ImageView) view.findViewById(R.id.csr2iv1);
		tv1 = (TextView) view.findViewById(R.id.csr2tv1);
		tv2 = (TextView) view.findViewById(R.id.csr2tv2);
	}
}

class myadapter extends ArrayAdapter<String> {

	Context context;
	int[] imagess;
	String[] titlesdays;
	String[] titledesc;
	
	

	public myadapter(Context context, String[] titles, int[] imgs, String[] desc) {

		super(context, R.layout.custom_row2, R.id.csr2tv1, titles);
		this.context = context;
		this.imagess = imgs;
		this.titlesdays = titles;
		this.titledesc = desc;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		MyHolder holder=null;
		if (row == null) {
			LayoutInflater l = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row = l.inflate(R.layout.custom_row2, parent, false);
			holder=new MyHolder(row);
			row.setTag(holder);
		}else{
			holder=(MyHolder) row.getTag();
		}
//		ImageView iv = (ImageView) row.findViewById(R.id.csr2iv1);
//		TextView tv1 = (TextView) row.findViewById(R.id.csr2tv1);
//		TextView tv2 = (TextView) row.findViewById(R.id.csr2tv2);

		holder.iv.setImageResource(imagess[position]);
		holder.tv1.setText(titlesdays[position]);
		holder.tv2.setText(titledesc[position]);
		return row;
	}

}
