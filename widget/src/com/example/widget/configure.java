package com.example.widget;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class configure extends Activity implements OnClickListener {

	private configure context;
	private int widjetid;
	EditText et;
	RemoteViews views;
	AppWidgetManager widget ;
	NotificationManager nm;
	static final int unique=1234;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure);
		setResult(RESULT_CANCELED);
		context = this;
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			widjetid = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);

		}
		widget = AppWidgetManager.getInstance(context);
		views = new RemoteViews(context.getPackageName(),
				R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText1);
		b= (Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(unique);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(et.getText().toString()));
		PendingIntent pd = PendingIntent.getActivity(context, 0, intent, 0);
		
		views.setOnClickPendingIntent(R.id.imageButton1, pd);
		widget.updateAppWidget(widjetid, views);
		
		Intent ireturn=new Intent();
		ireturn.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widjetid);
		setResult(RESULT_OK,ireturn);


		Intent intents=new Intent(intent.CATEGORY_HOME);
		PendingIntent pi=PendingIntent.getActivity(this,0, intents, 0);
		String body="YOUR URL IS:"+et.getText().toString();
		String title="WIDGET CREATED";
		Notification nn=new Notification(R.drawable.notification,body,System.currentTimeMillis());
		nn.setLatestEventInfo(this, title, body, pi);
		nn.defaults=Notification.DEFAULT_ALL;
		nm.notify(unique,nn);
		finish();

	}
}
