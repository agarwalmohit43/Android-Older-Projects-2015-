package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Notifications extends Activity implements OnClickListener {

	Button b;
	NotificationManager nm;
	static final int unique=1234;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(unique);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intents=new Intent(this,Notifications.class);
		PendingIntent pi=PendingIntent.getActivity(this,0, intents, 0);
		String body="welome to notifications";
		String title="MOHIT";
		Notification nn=new Notification(R.drawable.notification,body,System.currentTimeMillis());
		nn.setLatestEventInfo(this, title, body, pi);
		nn.defaults=Notification.DEFAULT_ALL;
		nm.notify(unique,nn);
		finish();
	}


}
