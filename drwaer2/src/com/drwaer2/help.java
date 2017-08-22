package com.drwaer2;

import com.drwaer2.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class help extends Activity implements OnClickListener {
	
	Button email,call;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		email=(Button) findViewById(R.id.emailbutton);
		call=(Button) findViewById(R.id.callbutton);
		
		email.setOnClickListener(this);
		call.setOnClickListener(this);
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
		Intent intent=null,chooser=null;
		switch(v.getId()){
		case R.id.emailbutton:
			intent=new Intent(help.this,email.class);
			startActivity(intent);
			
			break;
		case R.id.callbutton:
			String phone = "+918272933347";
			intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
			startActivity(intent);
			break;
		}
		
	}
}
