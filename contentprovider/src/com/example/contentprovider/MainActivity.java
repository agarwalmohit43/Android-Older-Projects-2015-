package com.example.contentprovider;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
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
		Cursor c=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null,null);
		while(c.moveToNext()){
			int nameindex=c.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String name=c.getString(nameindex);
			tv.setText(name);
		
		}
	}

}
