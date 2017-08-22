package com.example.mohit;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class clientweb extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		
		view.loadUrl(url);
		return super.shouldOverrideUrlLoading(view, url);
	}

	
	
	 
}
