package com.example.soundplayback;



import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class media extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.media);
		VideoView v=(VideoView) findViewById(R.id.videoView1);
		v.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory()+"/songs/sooraj.mp4"));
		v.setMediaController(new MediaController(this));
		v.start();
		v.requestFocus();
	}
}
