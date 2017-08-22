package com.example.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView) findViewById(R.id.tv);
		SQLiteDatabase db=openOrCreateDatabase("MYDB",MODE_PRIVATE,null);
		Cursor c=db.rawQuery("SELECT * FROM MYTABLE;", null);
		c.moveToFirst();
		String a=c.getString(1);
		tv.setText(a);
			
		db.close();
	
	}
	

}
