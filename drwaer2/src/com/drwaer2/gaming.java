package com.drwaer2;

import com.drwaer2.R;
import com.drwaer2.R.id;

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
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class gaming extends Activity implements OnClickListener {
	TabHost th;
	Button nfscord, nfsdetails, nfsvideo, fifacord, fifadetails, fifavideo,
			khetdetails, khetvideo, khetcord;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamingmain);
		nfscord = (Button) findViewById(R.id.nfscord);
		nfsdetails = (Button) findViewById(R.id.nfsdetails);
		nfsvideo = (Button) findViewById(R.id.nfsvideo);

		fifacord = (Button) findViewById(R.id.fifacord);
		fifadetails = (Button) findViewById(R.id.fifdetails);
		fifavideo = (Button) findViewById(R.id.fifavideo);

		khetcord = (Button) findViewById(R.id.fifacord3);
		khetdetails = (Button) findViewById(R.id.fifdetails3);
		khetvideo = (Button) findViewById(R.id.fifavideo3);

		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();

		TabSpec spec = th.newTabSpec("tag1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("NFS");
		th.addTab(spec);

		TabSpec specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("FIFA");
		th.addTab(specs);

		TabSpec khetspec = th.newTabSpec("tab3");
		khetspec.setContent(R.id.tab3);
		khetspec.setIndicator("KHET");
		th.addTab(khetspec);

		khetcord.setOnClickListener(this);
		khetdetails.setOnClickListener(this);
		khetvideo.setOnClickListener(this);

		nfscord.setOnClickListener(this);
		nfsdetails.setOnClickListener(this);
		nfsvideo.setOnClickListener(this);

		fifadetails.setOnClickListener(this);
		fifacord.setOnClickListener(this);
		fifavideo.setOnClickListener(this);

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
		Intent intent = null;
		switch (v.getId()) {
		case R.id.nfscord:
			d.setContentView(R.layout.customsss);
			d.setTitle("DIWAKER MANI");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView iv = (ImageView) d.findViewById(R.id.cusssiv);
			iv.setImageResource(R.drawable.nfscord);
			Button nfscall = (Button) d.findViewById(R.id.cusscall);
			Button nfswhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			nfscall.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					String phone = "+918820895085";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);

				}
			});
			nfswhats.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+918820895085");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});

			break;
		case R.id.nfsdetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.nfsdetails));
			d.show();
			break;

		case R.id.nfsvideo:
			startActivity(new Intent(
					Intent.ACTION_VIEW,
					Uri.parse("https://www.youtube.com/watch?x-yt-cl=84503534&feature=player_embedded&v=GkYze4Z2K64&x-yt-ts=1421914688")));
			break;
		case R.id.fifacord:
			d.setContentView(R.layout.customsss);
			d.setTitle("MOHIT KUMAR");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.mohitpass);
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
					Uri uri = Uri.parse("smsto:" + "+918697681939");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		case R.id.fifdetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView fifatv = (TextView) d.findViewById(R.id.eventsdeatils);
			fifatv.setText(getString(R.string.fifadetails));
			d.show();
			break;
		case R.id.fifavideo:
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.youtube.com/watch?v=wrkGDjP1jB8")));
			break;

		case R.id.fifacord3:

			d.setContentView(R.layout.customsss);
			d.setTitle("RANIT DE");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv3 = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv3.setImageResource(R.drawable.khetcord);
			Button fifacall3 = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats3 = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+918981590805";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+918981590805");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});

			break;

		case R.id.fifavideo3:

			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.youtube.com/watch?v=4nQaWJEBFNk")));

			break;

		case R.id.fifdetails3:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView khettv = (TextView) d.findViewById(R.id.eventsdeatils);
			khettv.setText(getString(R.string.khet));
			d.show();
			break;

		}
	}
}
