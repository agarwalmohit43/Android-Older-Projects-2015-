package com.example.launcher;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class video extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cideo);
		VideoView v = (VideoView) findViewById(R.id.videoView1);
        v.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lp));
        v.start();
	}
}
