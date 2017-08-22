package com.alphabetlearning;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class drawa extends Activity implements OnTouchListener, OnClickListener, SensorEventListener{
	ImageView imageView;
	Bitmap bitmap;
	Canvas canvas;
	Paint paint;
	Path path;
	private float movex;
	private float movey;
	private float oldmovey;
	private float oldmovex;
	ImageButton img1,img3,img4,img5,img6,img7,img8,img9,img10;
	private float lastAcceleration;
	private float currentAcceleration;
	private float acceleration;
	int color = Color.WHITE;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw);
		path = new Path ();
		imageView = (ImageView) this.findViewById(R.id.imageView1);
		img1=(ImageButton)findViewById(R.id.imageButton1);//home
		img3=(ImageButton)findViewById(R.id.imageButton3);//back
		img4=(ImageButton)findViewById(R.id.imageButton4);//back1
		img5=(ImageButton)findViewById(R.id.imageButton5);//sound
		img6=(ImageButton)findViewById(R.id.imageButton6);//chalk
		img7=(ImageButton)findViewById(R.id.imageButton7);//refresh
		img8=(ImageButton)findViewById(R.id.imageButton8);//logo1
		img9=(ImageButton)findViewById(R.id.imageButton9);//duster
		img10=(ImageButton)findViewById(R.id.imageButton10);//return
		
		
		
		
		acceleration = 0.0f;
		currentAcceleration = SensorManager.GRAVITY_EARTH;
		lastAcceleration = SensorManager.GRAVITY_EARTH;
		Display currentDisplay = getWindowManager().getDefaultDisplay();
		float dw = currentDisplay.getWidth();
		float dh = currentDisplay.getHeight();
		SensorManager sensor = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor.registerListener(this,
				sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
		bitmap = Bitmap.createBitmap((int) dw, (int) dh, Bitmap.Config.RGB_565);
		canvas = new Canvas(bitmap);
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(9);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setColor(color);
		
		
        
	        

	    

		

		
		
		imageView.setImageBitmap(bitmap);
		imageView.setImageResource(R.drawable.a);

		imageView.setOnTouchListener(this);
		img1.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
		img5.setOnClickListener(this);
		img6.setOnClickListener(this);
		img7.setOnClickListener(this);
		img8.setOnClickListener(this);
		img9.setOnClickListener(this);
		img10.setOnClickListener(this);
		
	}

	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		switch (action) 
		{
			case MotionEvent.ACTION_DOWN: oldmovex = event.getX();
											oldmovey = event.getY();
											path.moveTo(oldmovex, oldmovey);
											break;
			case MotionEvent.ACTION_MOVE: movex = event.getX();
											movey = event.getY();
											float dx = Math.abs(movex-oldmovex);
											float dy = Math.abs(movey-oldmovey);
											if (dx >= 4 || dy >= 4)
											{
												path.quadTo(oldmovex, oldmovey, (movex+oldmovex)/2, (movey+oldmovey)/2);
												oldmovex = movex;
												oldmovey = movey;
												canvas.drawPath(path, paint);
											}
											imageView.invalidate();
											break;
			case MotionEvent.ACTION_UP:     path.lineTo(oldmovex, oldmovey);
											canvas.drawPath(path, paint);
											imageView.invalidate();
											path.reset();
											break;
			case MotionEvent.ACTION_CANCEL:
				                            break;
			default: 
				                            break;
		}
		return true;
	}

	

	
	@Override
	public void onClick(View v) {
			
		switch(v.getId())
		{
		case R.id.imageButton1: Intent i1=new Intent(getApplicationContext(),Alphalisdraw.class);
		                        startActivity(i1);
		                        break;
		                        
		case R.id.imageButton3: Intent i2=new Intent(getApplicationContext(),drawa.class);
        						startActivity(i2);
        						break;
		case R.id.imageButton4: Intent i3=new Intent(getApplicationContext(),drawa.class);
        						startActivity(i3);
        						break;
        
		case R.id.imageButton5: Intent i4=new Intent(getApplicationContext(),drawa.class);
								startActivity(i4);
								break;
		
		case R.id.imageButton6: color=Color.WHITE;
								paint.setColor(color);
								break;

		case R.id.imageButton7: bitmap.eraseColor(Color.BLACK);
								imageView.invalidate();
								break;

		case R.id.imageButton8: final Dialog dia=new Dialog(drawa.this);
								dia.setContentView(R.layout.drawdialoglogo);
								dia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
								ImageView ih=(ImageView) dia.findViewById(R.id.dialogo);
								ih.setImageResource(R.drawable.a);
								dia.show();
								break;
								
case R.id.imageButton9: int pixelColor=Color.BLACK;
								int width=bitmap.getWidth();
								int height=bitmap.getHeight();
								for(int x=0;x<width;++x){
									for(int y=0;y<height;++y){
										pixelColor=bitmap.getPixel(x, y);
									}
								}
								if(pixelColor!=Color.WHITE)
									paint.setColor(pixelColor);
								else
									paint.setColor(Color.BLACK);
								break;
								

case R.id.imageButton10: Intent i9 =new Intent(getApplicationContext(),Drawandpractice.class);
								startActivity(i9);
								break;
   }
	}/*@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(img1.isPressed())
		{
			color=Color.BLUE;
			paint.setColor(color);
		}
		
		else if(img3.isPressed())
		{
			color=Color.RED;
			paint.setColor(color);
		}
		else if(img4.isPressed())
		{
			color=Color.GREEN;
			paint.setColor(color);
		}
		else if(img5.isPressed())
		{
			color=Color.YELLOW;
			paint.setColor(color);
		}
		else if(img6.isPressed())
		{
			int pixelColor=Color.WHITE;
			int width=bitmap.getWidth();
			int height=bitmap.getHeight();
			for(int x=0;x<width;++x){
				for(int y=0;y<height;++y){
					pixelColor=bitmap.getPixel(x, y);
				}
			}
			if(pixelColor!=Color.WHITE)
			paint.setColor(pixelColor);
			else
				paint.setColor(Color.WHITE);
		}
		else if(img7.isPressed())
		{
			color=Color.CYAN;
			paint.setColor(color);
		}
		else if(img8.isPressed())
		{
			color=Color.rgb(255, 128, 0);
			paint.setColor(color);
		}
		else if(img9.isPressed())
		{
			color=Color.rgb(128,0,255);
			paint.setColor(color);
		}
		else if(img10.isPressed())
		{
			color=Color.MAGENTA;
			paint.setColor(color);
		}
		
		
	}*/

	
	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		float x = arg0.values[0];
		float y = arg0.values[1];
		float z = arg0.values[2];

		lastAcceleration = currentAcceleration;
		currentAcceleration = x * x + y * y + z * z;

		acceleration = currentAcceleration
				* (currentAcceleration - lastAcceleration);
		if (acceleration > 15000) {
			bitmap.eraseColor(Color.BLACK);
			imageView.invalidate();
		}
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	


}
