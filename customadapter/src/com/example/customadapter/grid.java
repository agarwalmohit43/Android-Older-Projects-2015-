package com.example.customadapter;

import java.util.ArrayList;

import com.example.customadapter.myadapters.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class grid extends Activity implements OnItemClickListener {

	GridView gv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		gv = (GridView) findViewById(R.id.gridView1);
		gv.setAdapter(new myadapters(this));
		gv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Intent i=new Intent(this,mydialog.class);
		viewholder h=(viewholder) view.getTag();
		country temp=(country) h.gdiv.getTag();
		
		i.putExtra("countryimage", temp.images);
		i.putExtra("countryname", temp.countryname);
		startActivity(i);
	}
}

class country {
	String countryname;
	int images;

	public country(int image, String countrynames) {

		this.countryname = countrynames;
		this.images = image;
	}
}

class myadapters extends BaseAdapter {
	ArrayList<country> all;
	Context context;

	public myadapters(Context c) {
		all = new ArrayList<country>();
		this.context = c;
		String[] cname = c.getResources().getStringArray(R.array.country);
		int[] cimage = { R.drawable.flags1, R.drawable.flags2,
				R.drawable.flags3, R.drawable.flags4 };
		for (int i = 0; i < cname.length; i++) {
			country co = new country(cimage[i], cname[i]);
			all.add(co);
		}

	}

	@Override
	public int getCount() {

		return all.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return all.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class viewholder {
		ImageView gdiv;

		public viewholder(View v) {
			gdiv = (ImageView) v.findViewById(R.id.gridiv1);

		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewgroup) {

		View row = convertView;
		viewholder holder = null;
		if (row == null) {
			LayoutInflater li = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row = li.inflate(R.layout.gridlay, viewgroup, false);
			holder = new viewholder(row);
			row.setTag(holder);
		} else {
			holder = (viewholder) row.getTag();
		}
		country temp = all.get(position);
		holder.gdiv.setImageResource(temp.images);
		holder.gdiv.setTag(temp);
		return row;
	}

}
