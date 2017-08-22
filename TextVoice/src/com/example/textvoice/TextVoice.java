package com.example.textvoice;

import java.util.Locale;
import java.util.Random;


import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TextVoice extends Activity implements OnClickListener, OnSeekBarChangeListener {

	SeekBar sb;
	
	AudioManager am;
	Button b;
	static final String[] texts={"Mohit","Agarwal","Kumar"};
	TextToSpeech tts;
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_voice);
		et=(EditText) findViewById(R.id.editText1);
		sb = (SeekBar) findViewById(R.id.seekBar1);
	 
		b=(Button) findViewById(R.id.button1);
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		int maxv = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		int curv = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		sb.setMax(maxv);
		sb.setProgress(curv);
		b.setOnClickListener(this);
		tts=new TextToSpeech(TextVoice.this,new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				
				if(status!=TextToSpeech.ERROR){
					tts.setLanguage(Locale.US);
				}
			}
		});
		
		sb.setOnSeekBarChangeListener(this);
	}
	@Override
	protected void onPause() {

		if(tts!=null){
			tts.stop();
			tts.shutdown();
		}
		
		super.onPause();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String text=et.getText().toString();
		if(TextUtils.isEmpty(text)){
		    Toast.makeText(TextVoice.this, "ENTER THE TEXT", Toast.LENGTH_SHORT).show();

			Random r=new Random();
			String random=texts[r.nextInt(3)];
			tts.speak(random, TextToSpeech.QUEUE_FLUSH,null);
		}else{
			
			tts.speak(text, TextToSpeech.QUEUE_FLUSH,null);

		}
		
		
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	

}
