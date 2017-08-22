package com.example.customadapterusingbase;

import java.util.ArrayList;

import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new myadapter(this));
		lv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
			break;
		}		
	}

}

class singlerow {
	String days, desc;
	int images;

	public singlerow(String d, String n, int i) {
		this.days = d;
		this.desc = n;
		this.images = i;

	}

}

class myadapter extends BaseAdapter {

	ArrayList<singlerow> al;
	Context context;

	public myadapter(Context c) {
		context = c;
		al = new ArrayList<singlerow>();
		int images[] = { R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher };
		String days[] = c.getResources().getStringArray(R.array.days);

		String desc[] = c.getResources().getStringArray(R.array.no);

		for (int i = 0; i < days.length; i++) {
			al.add(new singlerow(days[i], desc[i], images[i]));
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return al.size();
	}

	@Override
	public Object getItem(int position) {

		
		return al.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewgroup) {

		LayoutInflater li = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View row = li.inflate(R.layout.activity_main, viewgroup, false);

		TextView tv1 = (TextView) row.findViewById(R.id.textView1);
		TextView tv2 = (TextView) row.findViewById(R.id.tv2);
		ImageView iv = (ImageView) row.findViewById(R.id.imageView1);

		singlerow temp = al.get(position);

		tv1.setText(temp.days);
		tv2.setText(temp.desc);
		iv.setImageResource(temp.images);

		return row;
	}

}
