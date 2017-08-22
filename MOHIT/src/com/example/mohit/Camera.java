package com.example.mohit;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{

	ImageButton ib;
	Button b;
	ImageView iv;
	int cameraResults;
	Intent i;
	final static int cameradata=0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.photo);
		initialise();
		InputStream is=getResources().openRawResource(R.drawable.ic_launcher);
		bmp=BitmapFactory.decodeStream(is);
		
	}

	private void initialise() {
		// TODO Auto-generated method stub
		
		ib=(ImageButton)findViewById(R.id.imageButton1);
		iv=(ImageView)findViewById(R.id.imageView1);
		b=(Button)findViewById(R.id.photobutton);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.photobutton:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
								break;
								
		case R.id.imageButton1:
			i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameradata);
								break;
		
		
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extra=data.getExtras();
			bmp=(Bitmap)extra.get("data");
			iv.setImageBitmap(bmp);
			
			
		}
		
	}
	
	

}
