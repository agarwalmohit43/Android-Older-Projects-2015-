package com.drwaer2.proficiency;

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
import android.widget.TextView;

public class ennovation extends Activity implements OnClickListener {
	Button cord, details;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.proenovation);
		details = (Button) findViewById(R.id.enoodetails);
		cord = (Button) findViewById(R.id.enocord);

		cord.setOnClickListener(this);
		details.setOnClickListener(this);
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

		switch (v.getId()) {
		case R.id.enoodetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.enovation));
			d.show();

			break;

		case R.id.enocord:
			d.setContentView(R.layout.customsss);
			d.setTitle("CORDINATOR");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.m);
			Button fifacall = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+919051144448";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+919975021003");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		}

	}
}
