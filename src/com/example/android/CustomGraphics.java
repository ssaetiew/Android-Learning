package com.example.android;

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

public class CustomGraphics extends View {
	
	Bitmap ball;
	float changeY;
	Typeface font;
	public CustomGraphics(Context context)
	{
		super(context);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.graphics);
		changeY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "VeraSeBd.ttf");
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);//background canvas is white
		
		//Setup text and draw
		Paint textPaint = new Paint();
		textPaint.setARGB(200, 255, 110, 59);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(100);
		textPaint.setTypeface(font); //font we downloaded and put in assets folder
		canvas.drawText("Oh My Face!!",canvas.getWidth()/2, 200, textPaint);
		
		canvas.drawBitmap(ball, (canvas.getWidth()/2), changeY, null);//draw ball
		if(changeY < canvas.getHeight())
		{
			changeY += 10;
		}
		else
		{
			changeY = 0;
		}
		
		//draw rectangle and paint it with blue
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 500);
		Paint blue = new Paint();
		blue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, blue);
		
		invalidate();
	}
	
}
