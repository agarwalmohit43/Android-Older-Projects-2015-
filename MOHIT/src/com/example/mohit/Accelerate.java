package com.example.mohit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends Activity implements SensorEventListener {

	float x,y,sensorx,sensory;
	Bitmap ball;
	SensorManager sm;
	Loverboysurface oursurfaceview;
	public class Loverboysurface extends SurfaceView implements Runnable {
		SurfaceHolder ourholder;
		Thread t=null;
		boolean isrunning=false;
		public Loverboysurface(Context context) {
			// TODO Auto-generated constructor stub
		super(context);
		ourholder=getHolder();
		}
		public void pause(){
			isrunning=false;
			while(true){
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			t=null;
		}
		public void resume(){
			 isrunning=true;
			 t=new Thread(this);
				t.start();	 
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isrunning){
				if(!ourholder.getSurface().isValid())
					continue;
				Canvas canvas=ourholder.lockCanvas();
				canvas.drawRGB(153,31,0);
				float centerx=canvas.getWidth()/2;
				float centery=canvas.getHeight()/2;
				canvas.drawBitmap(ball, centerx+sensorx*20, centery+sensory*20, null);
				
				ourholder.unlockCanvasAndPost(canvas);		
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		
		if(sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size()!=0){
			
			Sensor s=sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s,SensorManager.SENSOR_DELAY_NORMAL);
			
		}
		ball=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		x=y=sensorx=sensory=0;
		oursurfaceview=new Loverboysurface(this);
		oursurfaceview.resume();
		setContentView(oursurfaceview);

		
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sm.unregisterListener(this);
		super.onPause();
		
	}


	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
	try {
		Thread.sleep(16);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		sensorx=e.values[0];
		sensory=e.values[1];
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	

}
