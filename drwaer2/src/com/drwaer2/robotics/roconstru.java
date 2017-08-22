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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class roconstru extends Activity implements OnClickListener {
	final Context context = this;

	Button details, arena, cord;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roconstru);
		details = (Button) findViewById(R.id.roconstruetails);
		arena = (Button) findViewById(R.id.roconstruarena);
		cord = (Button) findViewById(R.id.roconstrucord);

		details.setOnClickListener(this);
		arena.setOnClickListener(this);
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
		case R.id.roconstruetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.roconstru));
			d.show();

			break;
		case R.id.roconstruarena:
			d.setContentView(R.layout.imageadaptertest);
			d.setTitle("AREANA");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			ViewPager navigvpg = (ViewPager)d.findViewById(R.id.imageadaptertest);
			roconstrudapter img = new roconstrudapter(this);
			navigvpg.setAdapter(img);
			d.show();
			break;
		case R.id.roconstrucord:
			d.setContentView(R.layout.customsss);
			d.setTitle(" Debajit Jotder");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.roconstrucord);
			Button fifacall = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+918336012562";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+918336012562");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		}
	}
}
class roconstrudapter extends PagerAdapter {

	Context context;
	private int[] image={R.drawable.techconstru1,R.drawable.techconstru2};

	public roconstrudapter(Context context){
		this.context=context;
	}
	

	public int getCount() {
		return image.length;
	}

	public boolean isViewFromObject(View view, Object object) {
		return view==((ImageView) object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		ImageView img=new ImageView(context);
		img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		img.setImageResource(image[position]);
		((ViewPager) container).addView(img, 0);
		return img;
	}
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}
	

}



