package com.example.mohit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {
EditText url;
WebView ourweb;
InputMethodManager im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);
		ourweb=(WebView)findViewById(R.id.wb);
		ourweb.getSettings().setJavaScriptEnabled(true);
		ourweb.getSettings().setLoadWithOverviewMode(true);
		ourweb.getSettings().setUseWideViewPort(true);
		
		ourweb.getSettings().setBuiltInZoomControls(true);
		ourweb.setWebViewClient(new clientweb());
		Button go=(Button)findViewById(R.id.bgo);
		Button goback=(Button)findViewById(R.id.bback);
		Button goforward=(Button)findViewById(R.id.buforward);
		Button refresh=(Button)findViewById(R.id.brefresh);
	Button history=(Button)findViewById(R.id.bhistory);
	url=(EditText)findViewById(R.id.wbet);
	go.setOnClickListener(this);
	goback.setOnClickListener(this);
	goforward.setOnClickListener(this);
	refresh.setOnClickListener(this);
	history.setOnClickListener(this);
	
	
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater muu= getMenuInflater();
		muu.inflate(R.menu.webmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.menugoback:
			if(ourweb.canGoBack()){
				ourweb.goBack();
				//hiding keyboard
			im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(url.getWindowToken(),0);
			}
				break;
				case R.id.menuforward:
					if(ourweb.canGoForward()){
						ourweb.goForward();
						
					}
					break;
				case R.id.menurefersh:
					ourweb.reload();
					break;
				case R.id.menuhistory:
					ourweb.clearHistory();
					break;
				
			}
		
		
		

		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bgo:
			String website=url.getText().toString();
			ourweb.loadUrl(website);
			
			break;
			
		case R.id.bback:
			if(ourweb.canGoBack()){
				ourweb.goBack();
			}
			break;
			
		case R.id.buforward:
			if(ourweb.canGoForward()){
				ourweb.goForward();
			}
			break;
		case R.id.brefresh:
			ourweb.reload();
			break;
			
		case R.id.bhistory:
			ourweb.clearHistory();
			break;
		}
		
	}
	
	
	
	
}
