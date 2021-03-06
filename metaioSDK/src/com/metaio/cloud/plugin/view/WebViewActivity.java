/**
 * WebViewActivity.java
 * Junaio 2.6 Android
 * 	
 * Junaio Web View	
 *
 * @author Created by Arsalan Malik on 1631 24.06.2011
 * Copyright 2011 metaio GmbH. All rights reserved.
 */
package com.metaio.cloud.plugin.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.metaio.R;
import com.metaio.cloud.plugin.MetaioCloudPlugin;
import com.metaio.cloud.plugin.data.MetaioCloudDataManager;
import com.metaio.cloud.plugin.util.MetaioCloudUtils;
import com.metaio.sdk.jni.ASWorldReturnCode;
import com.metaio.sdk.jni.AS_MetaioWorldRequestCommand;
import com.metaio.sdk.jni.MetaioWorldRequest;
import com.metaio.sdk.jni.MetaioWorldRequestChannelsManageGet;

public class WebViewActivity extends Activity {
	/**
	 * Web view
	 */
	private WebView mWebView;

	/**
	 * Progress bar displayed when loading a page
	 */
	private ProgressBar mProgressView;

	/**
	 * Navigation buttons that can be disabled
	 */
	private ImageButton mButtonBack, mButtonForward, mButtonStop;

	private static final int ID_OPENWINDOWLINK = 0x5;

	/**
	 * Set this to true to have a fullscreen webview without navigation controls
	 */
	public static boolean hideNavigationBar;

	@SuppressLint("SetJavaScriptEnabled")
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			//get url and navigatio preference (default true)
			final String url = getIntent().getStringExtra(getPackageName() + ".URL");
			final boolean navigation = getIntent().getBooleanExtra(getPackageName() + ".NAVIGATION", true);

			setContentView(R.layout.webviewnav);

			//if we want navigation bar and not hide it, make it visible. Make it invisible if not.
			if (navigation && !hideNavigationBar) {
				findViewById(R.id.webBottomBar).setVisibility(View.VISIBLE);
			} else {
				findViewById(R.id.webBottomBar).setVisibility(View.GONE);
			}

			mButtonBack = (ImageButton) findViewById(R.id.buttonWebBack);
			mButtonForward = (ImageButton) findViewById(R.id.buttonWebForward);
			mButtonStop = (ImageButton) findViewById(R.id.buttonWebStop);

			mProgressView = (ProgressBar) findViewById(R.id.progressBar);
			mProgressView.setIndeterminate(true);

			//init webview
			mWebView = (WebView) findViewById(R.id.webView);

			//disable hw accel as it creates flickering pages, html5  video won't work with this
			if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 16)
				mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

			// This hides white bar on the right
			mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

			WebSettings settings = mWebView.getSettings();
			// enable plugins before java script
			settings.setPluginState(PluginState.ON);

			//TODO test these two settings with a big webpage (cafe lotty?)
			settings.setLoadWithOverviewMode(true);
			settings.setUseWideViewPort(true);
			//enable javascript and zoom controls
			settings.setJavaScriptEnabled(true);
			settings.setBuiltInZoomControls(true);
			settings.setGeolocationEnabled(true);
			settings.setDatabaseEnabled(true);
			String databasePath = getDir("database_ext", Context.MODE_PRIVATE).getPath();
			settings.setDatabasePath(databasePath);
			settings.setDomStorageEnabled(true);

			//allow XMLHttpRequests
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
				settings.setAllowUniversalAccessFromFileURLs(true);

			JunaioWebViewClient client = new JunaioWebViewClient();
			mWebView.setWebViewClient(client);
			mWebView.setWebChromeClient(new JunaioWebChromeClient());

			registerForContextMenu(mWebView);

			if (savedInstanceState != null) {
				mWebView.restoreState(savedInstanceState);
			} else {

				//if we don't have to override the url, load it in the webview
				if (!client.shouldOverrideUrlLoading(mWebView, url))
					mWebView.loadUrl(url);
			}
		} catch (Exception e) {
			MetaioCloudPlugin.log("WebViewActivity.onCreate: " + e.getMessage());
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		try {
			MetaioCloudUtils.unbindDrawables(findViewById(android.R.id.content));

			mWebView.destroy();

		} catch (Exception e) {

		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mWebView.saveState(outState);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		try {
			//if we push back button and the browser can go back then go back 
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				if (mWebView.canGoBack()) {
					mWebView.goBack();
					return true;
				}
			}
		} catch (Exception e) {

		}

		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Click handlers for buttons
	 * 
	 * @param target Button that is clicked
	 */
	public void onButtonClickHandler(View target) {
		try {

			if (target.getId() == R.id.buttonWebBack) {
				if (mWebView.canGoBack()) {
					mWebView.goBack();
				}
			} else if (target.getId() == R.id.buttonWebReload) {
				mWebView.reload();
			} else if (target.getId() == R.id.buttonWebStop) {
				mWebView.stopLoading();
			} else if (target.getId() == R.id.buttonWebForward) {
				if (mWebView.canGoForward()) {
					mWebView.goForward();
				}
			} else if (target.getId() == R.id.buttonClose) {
				finish();
			} else if (target.getId() == R.id.buttonShare) {
				//				Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse(mWebView.getUrl()));
				//				startActivity(Intent.createChooser(intent, getString(R.string.BTN_SHARING)));
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mWebView.getUrl()));
				startActivity(Intent.createChooser(i, getString(R.string.BTN_SHARING)));
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		final HitTestResult result = ((WebView) v).getHitTestResult();

		MenuItem.OnMenuItemClickListener handler = new MenuItem.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case ID_OPENWINDOWLINK:
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getExtra()));
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
					break;

				default:
					break;
				}
				return true;
			}
		};

		if (result.getType() == HitTestResult.IMAGE_TYPE || result.getType() == HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {
			// Menu options for an image.
			//set the header title to the image url
			menu.setHeaderTitle(result.getExtra());
			//			menu.add(0, ID_SAVEIMAGE, 0, "Save Image").setOnMenuItemClickListener(handler);
			//			menu.add(0, ID_VIEWIMAGE, 0, "View Image").setOnMenuItemClickListener(handler);
			menu.add(0, ID_OPENWINDOWLINK, 0, getString(R.string.MENU_OPEN_IMG_EXTERNAL)).setOnMenuItemClickListener(handler);
		} else if (result.getType() == HitTestResult.ANCHOR_TYPE || result.getType() == HitTestResult.SRC_ANCHOR_TYPE) {
			// Menu options for a hyperlink.
			//set the header title to the link url
			menu.setHeaderTitle(result.getExtra());
			//			menu.add(0, ID_SAVELINK, 0, "Save Link").setOnMenuItemClickListener(handler);
			//			menu.add(0, ID_SHARELINK, 0, "Share Link").setOnMenuItemClickListener(handler);
			menu.add(0, ID_OPENWINDOWLINK, 0, getString(R.string.MENU_OPEN_LINK_EXTERNAL)).setOnMenuItemClickListener(handler);
		}

	}

	private class JunaioWebChromeClient extends WebChromeClient {

		@Override
		public void onProgressChanged(WebView view, int progress) {
			super.onProgressChanged(view, progress);
			mProgressView.setIndeterminate(false);
			mProgressView.setProgress(progress);
		}

		@Override
		public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
			int isBetaResId = getResources().getIdentifier("isBeta", "boolean", getPackageName());
			boolean isBeta = isBetaResId > 0 ? getResources().getBoolean(isBetaResId) : false;

			//if we are in beta, display errors as toasts
			if (MetaioCloudPlugin.isDebuggable || isBeta)
				Toast.makeText(getApplicationContext(), consoleMessage.message(), Toast.LENGTH_LONG).show();
			MetaioCloudPlugin.log(consoleMessage.message());

			return super.onConsoleMessage(consoleMessage);
		}

		@Override
		public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
			MetaioCloudPlugin.log("onJsAlert " + message);

			//display javascript alerts as AlertDialogs
			new AlertDialog.Builder(view.getContext()).setTitle("javaScript dialog").setMessage(message).setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					result.confirm();
				}
			}).setCancelable(false).create().show();

			return true;
		}

		@Override
		public boolean onJsTimeout() {
			MetaioCloudPlugin.log("onJsTimeout");
			return false;
		}

		public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
			quotaUpdater.updateQuota(estimatedSize * 2);
		}

		ViewGroup customView;
		WebChromeClient.CustomViewCallback mCustomViewCallback;

		@Override
		public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
			customView = (ViewGroup) LayoutInflater.from(getApplicationContext()).inflate(R.layout.html5container, null);

			//			mCustomView = new FrameLayout(getApplicationContext());
			//			FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
			//			mCustomView.setLayoutParams(lp);
			//			mCustomView.addView(view);

			mCustomViewCallback = callback;
			FrameLayout mHtml5Container = (FrameLayout) customView.findViewById(R.id.html5viewcontainer);
			mHtml5Container.addView(view);

			ImageButton closeButton = (ImageButton) customView.findViewById(R.id.buttonClose);
			closeButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					onHideCustomView();
				}
			});

			ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
			root.addView(customView);

		}

		@Override
		public void onHideCustomView() {
			ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
			root.removeView(customView);
			mCustomViewCallback.onCustomViewHidden();
		}

		@Override
		public Bitmap getDefaultVideoPoster() {
			return BitmapFactory.decodeResource(getResources(), R.drawable.default_video_poster);
		}

		@Override
		public View getVideoLoadingProgressView() {
			//			return customView.findViewById(android.R.id.progress);
			return new ProgressBar(getApplicationContext(), null, android.R.attr.progressBarStyleLarge);
		}
	}

	private class JunaioWebViewClient extends WebViewClient implements MetaioCloudDataManager.Callback {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			MetaioCloudPlugin.log("JunaioWebViewClient.shouldOverrideUrlLoading: " + url);

			// Try to launch default intent first if valid
			Intent intent = MetaioCloudPlugin.getDefaultIntent(WebViewActivity.this, url);
			if (intent != null) {
				try {
					startActivity(intent);
					return true;
				} catch (Exception e) {
					MetaioCloudPlugin.log(Log.ERROR, "WebViewActivity: Failed to launched the default intent");
					return false;
				}
			}

			if (url.compareToIgnoreCase("junaio://?action=closewebview") == 0) {
				MetaioCloudPlugin.log("Closing webview: " + url);
				finish();
				return true;
			} else if (url.startsWith("junaio://channels/")) {
				try {
					Uri uri = Uri.parse(url);

					String channelID = uri.getQueryParameter("id");

					if (channelID == null) {
						channelID = url.substring(url.lastIndexOf('=') + 1);
					}

					MetaioCloudPlugin.log("Channel ID: " + channelID);

					MetaioWorldRequestChannelsManageGet channelsGetRequest = new MetaioWorldRequestChannelsManageGet();
					channelsGetRequest.setChannelID(Integer.parseInt(channelID));
					MetaioCloudPlugin.getDataManager().addRequest(channelsGetRequest);

					MetaioCloudPlugin.getDataManager().registerCallback(this);

					return true;
				} catch (Exception e) {
					MetaioCloudPlugin.log(Log.ERROR, "Invalid URL: " + e.getMessage());
					return false;
				}

			}
			// Handling junaio://channel/switchChannel/?id=10533&filter_poissearch=Hallo
			else if (url.startsWith("junaio://channel/switchChannel/?")) {
				try {
					int channelID = -1;

					if (channelID > 0) {
						MetaioCloudPlugin.log("Channel ID: " + channelID);

						// TODO: return channel ID from this Activity and LiveView should open the channel

						MetaioWorldRequestChannelsManageGet channelsGetRequest = new MetaioWorldRequestChannelsManageGet();
						channelsGetRequest.setChannelID(channelID);
						MetaioCloudPlugin.getDataManager().addRequest(channelsGetRequest);

						MetaioCloudPlugin.getDataManager().registerCallback(this);

						return true;

					}
				} catch (Exception e) {
					MetaioCloudPlugin.log(Log.ERROR, "Invalid URI: " + e.getMessage());
					return false;
				}

			}
			// Open in Google Docs viewer if supported file type (based on file extention)
			else if (MetaioCloudPlugin.isSupportedOnGoogleDocs(url) && !url.contains("docs.google.com/gview?embedded")) {
				url = "http://docs.google.com/gview?embedded=true&url=" + url;
				view.loadUrl(url);
				return true;

			} else if (url.contains("youtube.com")) {
				Uri parsedUrl = Uri.parse(url);
				Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, parsedUrl);
				startActivity(youtubeIntent);
				finish();
				return true;
			}

			return false;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			MetaioCloudPlugin.log("Started loading " + url);
			mProgressView.setVisibility(View.VISIBLE);

			if (mButtonStop != null) {
				mButtonStop.setEnabled(true);
			}
			changeButtonState(view);
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			MetaioCloudPlugin.log("Finished loading " + url);
			//			if(!redirect){
			//				loadingFinished = true;
			//			}
			//			if(loadingFinished && !redirect){
			mProgressView.setVisibility(View.GONE);

			if (mButtonStop != null) {
				mButtonStop.setEnabled(false);
			}
			changeButtonState(view);
			//			} else {
			//				redirect = false;
			//			}
			view.resumeTimers();
			super.onPageFinished(view, url);
		}

		@Override
		public void onLoadResource(WebView view, String url) {
			super.onLoadResource(view, url);
			view.resumeTimers();
			MetaioCloudPlugin.log("onLoadResource " + url);
		}

		private void changeButtonState(WebView webview) {
			if (mButtonBack != null && mButtonForward != null) {
				if (webview.canGoBack()) {
					mButtonBack.setEnabled(true);
				} else {
					mButtonBack.setEnabled(false);
				}
				if (webview.canGoForward()) {
					mButtonForward.setEnabled(true);
				} else {
					mButtonForward.setEnabled(false);
				}
			}
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			MetaioCloudPlugin.log("Failed loading " + failingUrl + " " + description);
			mProgressView.setVisibility(View.GONE);

			MetaioCloudUtils.showToast(WebViewActivity.this, description);
			super.onReceivedError(view, errorCode, description, failingUrl);
		}

		@Override
		public void onRequestStarted() {
			//			mProgressView.setVisibility(View.VISIBLE);
		}

		@Override
		public void onRequestCompleted(MetaioWorldRequest request, int error) {
			//			mProgressView.setVisibility(View.GONE);

			if (error == ASWorldReturnCode.AS_WORLD_API_SUCCESS.swigValue()) {
				if (request.getCommand() == AS_MetaioWorldRequestCommand.AS_MetaioWorldRequestType_CHANNELS_MANAGE_GET) {
					//					JunaioViewActivity.setChannel(((MetaioWorldRequestChannelsManageGet)request).getResult()/*, channelFilters*/);
					MetaioCloudPlugin.getDataSource().setChannel(((MetaioWorldRequestChannelsManageGet) request).getResult());
					finish();
				}
			}

		}

		@Override
		public void onRequestCancelled(MetaioWorldRequest request) {
			//			mProgressView.setVisibility(View.GONE);

		}

	}

}
