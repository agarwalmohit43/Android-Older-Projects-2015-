package com.example.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	ImageView iv;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.button1);
		iv=(ImageView) findViewById(R.id.imageView1);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
Intent i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(i,0);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Bitmap bm=(Bitmap) data.getExtras().get("data");
		iv.setImageBitmap(bm);
		
		super.onActivityResult(requestCode, resultCode, data);
	}
}
