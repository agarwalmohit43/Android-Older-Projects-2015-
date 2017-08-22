package com.example.mohit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {
	TabHost th;
	TextView showresult;
	long start,stop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		
		
		showresult=(TextView)findViewById(R.id.tabtextview1);
		
		Button addtab=(Button)findViewById(R.id.btb3add);
		Button bstart=(Button)findViewById(R.id.bstartwatch);
		Button bstop=(Button)findViewById(R.id.bstopwatch);
		
		addtab.setOnClickListener(this);
		bstart.setOnClickListener(this);
		bstop.setOnClickListener(this);
		
		th=(TabHost)findViewById(R.id.tabhost);
		th.setup();
		
		
		TabSpec specs=th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Stowatch");
		th.addTab(specs);
		
	    specs=th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		
		specs=th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a tab");
		th.addTab(specs);
		start=0;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bstartwatch:
			
			start=System.currentTimeMillis();
			break;
		case R.id.bstopwatch:
			stop=System.currentTimeMillis();
			if(start!=0){
				long result=stop-start;
				int milli=(int)result;
				int second=milli/1000;
				int minutes=second/60;
				milli=milli%100;
				second=second%60;
				showresult.setText(String.format("%d:%02d:%02d",minutes,second,milli));
			}
			break;
		case R.id.btb3add:
			TabSpec ts=th.newTabSpec("tag1");
			ts.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView tv=new TextView(Tabs.this);
					tv.setText("you have created a new tab");
					return (tv);
				}
			});
			ts.setIndicator("New");
			th.addTab(ts);
			
			
			break;
		}
		
	}
	
	
	

}
