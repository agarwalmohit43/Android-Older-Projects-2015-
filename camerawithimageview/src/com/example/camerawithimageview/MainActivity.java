package com.example.camerawithimageview;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener {

	Button bt;
	ImageButton ibt;
	ImageView iv;
	int cameraresult;
	final static int cameradata=0;
	Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        
       initialise();
       bt.setOnClickListener(this);
       ibt.setOnClickListener(this);
       InputStream is=getResources().openRawResource(R.drawable.ic_launcher);
       bmp=BitmapFactory.decodeStream(is);
        
    }
	private void initialise() {
		// TODO Auto-generated method stub
		bt=(Button)findViewById(R.id.button1);
		ibt=(ImageButton)findViewById(R.id.imageButton1);
		iv=(ImageView)findViewById(R.id.imageView1);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.button1:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							break;
		case R.id.imageButton1:
			Intent i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameradata);
			break;
			
		
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode==RESULT_OK){
			Bundle bu=new Bundle();
			bu=data.getExtras();
			bmp=(Bitmap)bu.get("data");
			iv.setImageBitmap(bmp);
			
		}
	}


   
   
}
