package com.example.mohit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class Loverboy extends View {
	
	Bitmap pic;
	float changingY;
	Typeface font;

	public Loverboy(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	pic=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
changingY=0;
font=Typeface.createFromAsset(context.getAssets(),"G-Unit.ttf");

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		Paint pp=new Paint();
		pp.setARGB(50, 254, 10,50);
		pp.setTextAlign(Align.CENTER);
		pp.setTextSize(50);
		pp.setTypeface(font);
		canvas.drawText("LOVERBOY43",(canvas.getWidth()/2),200, pp);
		canvas.drawBitmap(pic, (canvas.getWidth()/2),changingY, null);
		if(changingY<canvas.getHeight()){
			changingY +=10;
			
		}else{
			changingY=0;
		}
		Rect rc=new Rect();
		rc.set(0, 400, canvas.getWidth(),550);
		Paint ourblue=new Paint();
		ourblue.setColor(Color.BLUE);
		canvas.drawRect(rc, ourblue);
		invalidate();
	}

	
}
