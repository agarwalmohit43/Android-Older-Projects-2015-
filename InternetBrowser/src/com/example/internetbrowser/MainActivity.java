package com.example.internetbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnEditorActionListener {

	EditText url;
	Button go, full;
	WebView webview;
	LinearLayout rv;
	InputMethodManager im;
	static int counter=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		url = (EditText) findViewById(R.id.wbet);
		go = (Button) findViewById(R.id.bgo);
		webview = (WebView) findViewById(R.id.wb);

		webview.setScrollbarFadingEnabled(true);
		webview.getSettings().setLoadsImagesAutomatically(true);
		webview.getSettings().setSupportZoom(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.getSettings().setBuiltInZoomControls(true);
		rv = (LinearLayout) findViewById(R.id.linearLayout1);
		webview.setWebViewClient(new clientweb());

		url.setOnEditorActionListener(this);
		full = (Button) findViewById(R.id.wbbt);
		go.setOnClickListener(this);
		full.setOnClickListener(this);

	}

	
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		counter++;
		if(counter==2){
			AlertDialog.Builder bu = new AlertDialog.Builder(
					MainActivity.this);
			bu.setMessage("ARE YOU SURE WANT TO EXIT");
			bu.setCancelable(false);
			bu.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,
								int which) {
							MainActivity.this.finish();
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
		}else{
		if (webview.canGoBack()) {
			webview.goBack();
			// hiding keyboard
			im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			im.hideSoftInputFromWindow(url.getWindowToken(), 0);
			Toast.makeText(MainActivity.this,"DOUBLE TAP TO EXIT",Toast.LENGTH_SHORT).show();

		}else{
			AlertDialog.Builder bu = new AlertDialog.Builder(
					MainActivity.this);
			bu.setMessage("ARE YOU SURE WANT TO EXIT");
			bu.setCancelable(false);
			bu.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,
								int which) {
							MainActivity.this.finish();
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
		}}
	}




	
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// Save the state of the WebView
		webview.saveState(outState);
	}

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// Restore the state of the WebView
		webview.restoreState(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.webitems, menu);
		MenuInflater muu = getMenuInflater();
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.menugoback:
			if (webview.canGoBack()) {
				webview.goBack();
				// hiding keyboard
				im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				im.hideSoftInputFromWindow(url.getWindowToken(), 0);
			}
			break;
		case R.id.menuforward:
			if (webview.canGoForward()) {
				webview.goForward();
			}
			break;
		case R.id.menurefersh:
			webview.reload();
			break;
		case R.id.menuhistory:
			webview.clearHistory();
			break;

		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bgo:
			String website = "http://"+url.getText().toString();
			webview.loadUrl(website);
			break;
		case R.id.wbbt:
			if (rv.getVisibility() == View.VISIBLE) {

				rv.setVisibility(View.GONE);
			} else {
				rv.setVisibility(View.VISIBLE);
			}

			break;
		}

	}




	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

		if(actionId==EditorInfo.IME_ACTION_GO){
			String website = "http://"+url.getText().toString();
			webview.loadUrl(website);
			return true;
		}
		return false;
	}
}
