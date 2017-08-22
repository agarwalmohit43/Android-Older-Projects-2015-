package com.drwaer2.robotics;


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

public class rocombat extends Activity implements OnClickListener {
	final Context context = this;

	Button details,arena,cord;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rocombat);
		details=(Button) findViewById(R.id.rocombatdetails);
		arena=(Button) findViewById(R.id.rocombatarena);
		cord=(Button) findViewById(R.id.rocombatcord);
		
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
		Intent intent=null;
		switch(v.getId()){
		case R.id.rocombatdetails:
			d.setContentView(R.layout.eventdetails);
			d.setTitle("DETAILS");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));
			TextView tvs = (TextView) d.findViewById(R.id.eventsdeatils);
			tvs.setText(getString(R.string.rocombat));
			d.show();
			
			break;
		case R.id.rocombatarena:
			intent=new Intent(rocombat.this,rocombatimageadapter.class);
			startActivity(intent);
			break;
		case R.id.rocombatcord:
			d.setContentView(R.layout.customsss);
			d.setTitle(" Abhisek Datta ");
			d.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			ImageView fifacordiv = (ImageView) d.findViewById(R.id.cusssiv);
			fifacordiv.setImageResource(R.drawable.combatcord);
			Button fifacall = (Button) d.findViewById(R.id.cusscall);
			Button fifawhats = (Button) d.findViewById(R.id.cusswhats);
			d.show();
			fifacall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String phone = "+919434314908";
					Intent nfscalls = new Intent(Intent.ACTION_DIAL, Uri
							.fromParts("tel", phone, null));
					startActivity(nfscalls);
				}
			});
			fifawhats.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("smsto:" + "+919434314908");
					Intent nfswhat = new Intent(Intent.ACTION_SENDTO, uri);
					nfswhat.setPackage("com.whatsapp");
					startActivity(nfswhat.createChooser(nfswhat, ""));
				}
			});
			break;
		}
	}
}
