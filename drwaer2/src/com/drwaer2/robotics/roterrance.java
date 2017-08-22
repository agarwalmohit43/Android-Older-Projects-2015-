package com.drwaer2.robotics;

import com.drwaer2.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class roterrance extends Activity implements OnClickListener,
		OnItemSelectedListener {
	final Context context = this;

	Button details, cord;
	Spinner arena;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roterrance);
		details = (Button) findViewById(R.id.roterrancedetails);
		cord = (Button) findViewById(R.id.roterrancecord);
		arena = (Spinner) findViewById(R.id.roterrancespinner1);

		ArrayAdapter are = ArrayAdapter
				.createFromResource(getBaseContext(), R.array.roterrance,
						android.R.layout.simple_dropdown_item_1line);
		arena.setAdapter(are);
		arena.setOnItemSelectedListener(this);
		details.setOnClickListener(this);
		cord.setOnClickListener(this);
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
	public void onClick(View v) {
		final Dialog d = new Dialog(context);
		Intent intent = null;
		switch (v.getId()) {
		case R.id.roterrancedetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.roterrance));
			d.show();

			break;
		case R.id.roterrancecord:
			d.setContentView(R.layout.customsss);
			d.setTitle(" Dhriti Majumder ");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.terrancecord);
			Button fifacall = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+918902468237";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+918902468237");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		final Dialog dd = new Dialog(context);
		switch (position) {
		case 1:
			dd.setContentView(R.layout.imageadaptertest);
			dd.setTitle("AREANA");
			dd.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			ViewPager navigvpg = (ViewPager) dd
					.findViewById(R.id.imageadaptertest);
			roterranceimageadapter img = new roterranceimageadapter(this);
			navigvpg.setAdapter(img);
			dd.show();
			break;
		case 2:
			Toast.makeText(context, "ARENA WILL DE DISPLAYED AFTERWARDS",
					Toast.LENGTH_LONG).show();
			// dd.setContentView(R.layout.imageadaptertest);
			// dd.setTitle("AREANA");
			// dd.getWindow().setBackgroundDrawable(
			// new ColorDrawable(android.graphics.Color.TRANSPARENT));
			// ViewPager navigvpgs =
			// (ViewPager)dd.findViewById(R.id.imageadaptertest);
			// roterranceimageadapter2 imgs = new roterranceimageadapter2(this);
			// navigvpgs.setAdapter(imgs);
			// dd.show();
			break;
		}
		arena.setSelection(0);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}

class roterranceimageadapter extends PagerAdapter {

	Context context;
	private int[] image = { R.drawable.techterrance1 };

	public roterranceimageadapter(Context context) {
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

		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
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

class roterranceimageadapter2 extends PagerAdapter {

	Context context;
	private int[] image = { R.drawable.terrancecord, R.drawable.terrancecord };

	public roterranceimageadapter2(Context context) {
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

		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
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
