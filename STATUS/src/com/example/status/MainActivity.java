package com.example.status;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
Toast t=Toast.makeText(MainActivity.this,"YOU POPED OUT THE NOTIFICATION",5000);
t.setGravity(Gravity.CENTER,0,0);
t.show();
		NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notify=new Notification(android.R.drawable.stat_notify_more, 
				"notification by Mohit!", System.currentTimeMillis());
		Context context=MainActivity.this;
		CharSequence title="YOU ARE BEING NOTIFIED BY MOHIT";
		CharSequence details="GO AND PLAY FIFA";
		Intent in=new Intent(context,MainActivity.class);
		 PendingIntent pending=PendingIntent.getActivity(context,0, in,0);
		 notify.setLatestEventInfo(context, title, details, pending);
		 notify.sound=Uri.parse("android.resource://com.example.status/"+R.raw.beep);
		 nm.notify(0,notify);
	}

	
}
