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
import android.widget.EditText;

public class email extends Activity implements OnClickListener {
	EditText sub,text;
	Button send;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.email);
	sub=(EditText) findViewById(R.id.emailsubject);
	text=(EditText) findViewById(R.id.emailtext);
	send=(Button) findViewById(R.id.emailsend);
	send.setOnClickListener(this);
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

		String subject=sub.getText().toString();
		String body=text.getText().toString();
		switch(v.getId()){
		case R.id.emailsend:
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.setData(Uri.parse("mailto:"));
			Uri imageS = Uri
					.parse("android.resource://com.example.launcher/drawable/"
							+ R.drawable.dr);

			intent.putExtra(intent.EXTRA_STREAM, imageS);
			intent.setType("image/*");

			String[] to = { "techstorm2.15@bppimt.ac.in" };
			intent.putExtra(intent.EXTRA_EMAIL, to);
			intent.putExtra(intent.EXTRA_SUBJECT,
					subject);
			intent.putExtra(intent.EXTRA_TEXT,body);
			intent.setType("message/rfc822");
			chooser = intent.createChooser(intent, "MOHIT MAIL");
			startActivity(chooser);
			break;
		}
	}
}
