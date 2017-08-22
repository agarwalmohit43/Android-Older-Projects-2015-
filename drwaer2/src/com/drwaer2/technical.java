package com.drwaer2;

import com.drwaer2.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class technical extends Activity implements OnClickListener {

	TabHost th;
	Button ennocord, ennodetails, techcord, techdetails;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.technicalmain);

		ennocord = (Button) findViewById(R.id.ennocord);
		ennodetails = (Button) findViewById(R.id.ennodetails);

		techcord = (Button) findViewById(R.id.techocord);
		techdetails = (Button) findViewById(R.id.techodetails);

		th = (TabHost) findViewById(R.id.tabhosttechnical);
		th.setup();

		TabSpec spec = th.newTabSpec("tag1");
		spec.setContent(R.id.tab1tech);
		spec.setIndicator("TECHNOMANIA");
		th.addTab(spec);

		TabSpec specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2tech);
		specs.setIndicator("E-nnovation");
		th.addTab(specs);

		ennocord.setOnClickListener(this);
		ennodetails.setOnClickListener(this);

		techcord.setOnClickListener(this);
	techdetails.setOnClickListener(this);

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
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

		switch (v.getId()) {

		case R.id.ennocord:
			d.setContentView(R.layout.customsss);
			d.setTitle("ROSHNI DASGUPTA");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.ennovationcord);
			Button fifacall = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+918017365649";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+918017365649");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		case R.id.ennodetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.enovation));
			d.show();
			break;
		case R.id.techocord:
			d.setContentView(R.layout.customsss);
			d.setTitle("AJIT KUMAR");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordivs = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordivs.setImageResource(R.drawable.techocord);
			Button fifacalls = (Button) d.findViewById(R.id.cusscall);
			Button fifawhatss = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacalls.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+919681009563";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhatss.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+919681009563");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		case R.id.techodetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvss = (TextView) d.findViewById(R.id.eventsdeatils);
			tvss.setText(getString(R.string.technomania));
			d.show();
			break;
		}

	}
}
