package com.example.mohit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	Loverboysurface oursurfaceview;
	float x,y,sX,sY,fX,fY,dX,dY,aniX,aniY,scaledX,scaledY;
	Bitmap bmp,plus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		oursurfaceview=new Loverboysurface(this);
		oursurfaceview.setOnTouchListener(this);
		x=0;
		y=0;
		sX=0;
		sY=0;
		fY=0;
		fX=0;
		dX=dY=aniX=aniY=scaledX=scaledY=0;
		bmp=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		plus=BitmapFactory.decodeResource(getResources(), R.drawable.plus2);

		setContentView(oursurfaceview);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		oursurfaceview.resume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursurfaceview.resume();
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x=event.getX();
		y=event.getY();
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			sX=event.getX();
			sY=event.getY();
			dX=dY=aniX=aniY=scaledX=scaledY=fX=fY=0;

			break;
			
		case MotionEvent.ACTION_UP:
			fX=event.getX();
			fY=event.getY();
			dX=fX-sX;
			dY=fY-sY;
			scaledX=dX/30;
			scaledY=dY/30;
			x=y=0;
			break;
			
		}
		return true;
		
	}
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
				canvas.drawRGB(02, 02, 150);
				if(x!=0&&y!=0){
					canvas.drawBitmap(bmp, x-(bmp.getWidth()/2), y-(bmp.getHeight()/2), null);
				}
				if(sX!=0&&sY!=0){
					canvas.drawBitmap(plus, sX-(plus.getWidth()/2), sY-(plus.getHeight()/2), null);
				}
				if(fX!=0&&fY!=0){
					canvas.drawBitmap(bmp, fX-(bmp.getWidth()/2)-aniX, fY-(bmp.getHeight()/2)-aniY, null);

					canvas.drawBitmap(plus, fX-(plus.getWidth()/2), fY-(plus.getHeight()/2), null);
				}
				aniX+=scaledX;
				aniY+=scaledY;
				ourholder.unlockCanvasAndPost(canvas);		
			}
		}
	}
}
