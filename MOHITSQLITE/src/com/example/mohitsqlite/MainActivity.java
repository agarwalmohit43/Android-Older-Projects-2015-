package com.example.mohitsqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	NotificationManager nm;
	static final int unique = 1234;
	EditText etid, etname, etnm;
	Button save, show, delete;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		etid = (EditText) findViewById(R.id.editText1);
		etname = (EditText) findViewById(R.id.editText2);
		etnm = (EditText) findViewById(R.id.editText3);

		save = (Button) findViewById(R.id.button1);
		delete = (Button) findViewById(R.id.button3);

		show = (Button) findViewById(R.id.button2);
		save.setOnClickListener(this);
		show.setOnClickListener(this);
		delete.setOnClickListener(this);
		db = openOrCreateDatabase("MYDB", MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS MYTABLE(ID VARCHAR,NAME VARCHAR,NICKNAME VARCHAR);");

		nm.cancel(unique);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String a = etid.getText().toString();

		switch (v.getId()) {
		case R.id.button1:
			Cursor curs = db.rawQuery("SELECT ID FROM MYTABLE", null);
			if(curs.getCount()!= 0){
				
				while (curs.moveToNext()){
					String iid=curs.getString(0);
					if(a.equals(iid)){
						Toast.makeText(MainActivity.this, "ID ALREADY EXISTS",
								Toast.LENGTH_SHORT).show();
					}else{
						String b = etname.getText().toString().toUpperCase();
						String n = etnm.getText().toString().toUpperCase();
						if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)
								|| TextUtils.isEmpty(n)){
							Toast.makeText(MainActivity.this,
									"ENTER THE ID,NAME,NICKNAME",
									Toast.LENGTH_SHORT).show();
						}else{
							db.execSQL("INSERT INTO MYTABLE VALUES('" + a
									+ "','" + b + "','" + n + "');");

							CharSequence text = "DATA SAVED";
							int duration = Toast.LENGTH_SHORT;
							Toast toast = Toast.makeText(getBaseContext(),
									text, duration);
							toast.show();
							etid.setText("");
							etname.setText("");
							etnm.setText("");

							// notification
							Intent intents = new Intent(this,
									MainActivity.class);
							PendingIntent pi = PendingIntent.getActivity(this,
									0, intents, 0);
							String body = "ID:" + a + " NAME:" + b
									+ " NICKNAME:" + n;
							String title = "DATA SAVED";
							Notification nn = new Notification(
									R.drawable.notification, body,
									System.currentTimeMillis());
							nn.setLatestEventInfo(this, title, body, pi);
							nn.defaults = Notification.DEFAULT_ALL;
							nm.notify(unique, nn);
						}
					}
				}
			}else{
				String b = etname.getText().toString().toUpperCase();
				String n = etnm.getText().toString().toUpperCase();
				if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)
						|| TextUtils.isEmpty(n)){
					Toast.makeText(MainActivity.this,
							"ENTER THE ID,NAME,NICKNAME",
							Toast.LENGTH_SHORT).show();
				}else{
					db.execSQL("INSERT INTO MYTABLE VALUES('" + a
							+ "','" + b + "','" + n + "');");

					CharSequence text = "DATA SAVED";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(getBaseContext(),
							text, duration);
					toast.show();
					etid.setText("");
					etname.setText("");
					etnm.setText("");

					// notification
					Intent intents = new Intent(this,
							MainActivity.class);
					PendingIntent pi = PendingIntent.getActivity(this,
							0, intents, 0);
					String body = "ID:" + a + " NAME:" + b
							+ " NICKNAME:" + n;
					String title = "DATA SAVED";
					Notification nn = new Notification(
							R.drawable.notification, body,
							System.currentTimeMillis());
					nn.setLatestEventInfo(this, title, body, pi);
					nn.defaults = Notification.DEFAULT_ALL;
					nm.notify(unique, nn);
				}
			}
			
				break;
		case R.id.button2:

			if (TextUtils.isEmpty(a)) {
				Toast.makeText(MainActivity.this, "ENTER THE ID",
						Toast.LENGTH_SHORT).show();

			} else {

				try {
					Cursor c = db.rawQuery("SELECT * FROM MYTABLE WHERE ID='"
							+ a + "'", null);
					c.moveToFirst();

					String name = c.getString(1);
					String nname = c.getString(2);

					etname.setText(name);
					etnm.setText(nname);
				} catch (Exception e) {
					CharSequence texts = "INVALID ID";
					int durations = Toast.LENGTH_SHORT;
					Toast toasts = Toast.makeText(getBaseContext(), texts,
							durations);
					toasts.show();
				}
			}

			break;
	case R.id.button3:
			if (TextUtils.isEmpty(a)) {
				Toast.makeText(MainActivity.this, "ENTER THE ID",
						Toast.LENGTH_SHORT).show();

			} else {
				final String delet = etid.getText().toString();
				Cursor curss = db.rawQuery("SELECT ID FROM MYTABLE", null);
				while (curss.moveToNext()) {
					String idd = curss.getString(0);
					if (a.equals(idd)) {

						AlertDialog.Builder bu = new AlertDialog.Builder(
								MainActivity.this);
						bu.setMessage("ARE YOU SURE WANT TO DELETE");
						bu.setCancelable(false);
						bu.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										db.execSQL("DELETE FROM MYTABLE WHERE ID='"
												+ delet + "'");
										Toast.makeText(
												MainActivity.this,
												"DELETED " + delet
														+ " SUCCESSFULLY",
												Toast.LENGTH_SHORT).show();
										etid.setText("");
										etname.setText("");
										etnm.setText("");
									}
								});
						bu.setNegativeButton("No",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.cancel();
									}
								});
						AlertDialog alert = bu.create();
						alert.show();

					} else {
						Toast.makeText(MainActivity.this, "INVALID ID",
								Toast.LENGTH_SHORT).show();

					}
				}

			}
			break;
		}

	}
}
