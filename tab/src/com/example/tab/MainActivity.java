package com.example.tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements OnClickListener {
	Button b1, b2;
	TabHost th;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button) findViewById(R.id.bstartwatch);
		b2=(Button) findViewById(R.id.bstopwatch);
		th=(TabHost) findViewById(R.id.tabhost);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
		th.setup();
		
		TabSpec specs=th.newTabSpec("tab1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("TAB 1");
		th.addTab(specs);
		
		TabSpec spec=th.newTabSpec("tab1");
		spec.setContent(R.id.tab2);
		spec.setIndicator("TAB 2");
		th.addTab(spec);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {

	switch(v.getId()){
	case R.id.bstartwatch:
		Toast.makeText(this,"hi u r in tab 1",Toast.LENGTH_SHORT).show();
		break;
	}
	
	}

}
