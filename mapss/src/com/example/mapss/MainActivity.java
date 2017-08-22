package com.example.mapss;

import java.util.Locale;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

public class MainActivity extends Activity implements OnMapReadyCallback {

	TextToSpeech tts;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	        MapFragment mapFragment = (MapFragment) getFragmentManager()
	                .findFragmentById(R.id.map);
	        mapFragment.getMapAsync(this);
	        tts=new TextToSpeech(this,new TextToSpeech.OnInitListener() {
				
				@Override
				public void onInit(int status) {
					
					if(status!=TextToSpeech.ERROR){
						tts.setLanguage(Locale.US);
					}
				}
			});
	        String random="welcome to map designed by mohit";
	        tts.speak(random, TextToSpeech.QUEUE_FLUSH,null);
	    }

	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub
		 map.setMyLocationEnabled(true);
	}

	     
	}
