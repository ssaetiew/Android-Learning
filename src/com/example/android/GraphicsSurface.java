
package com.example.android;

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

public class GraphicsSurface extends Activity implements OnTouchListener{

	CustomGraphicsSurface cgs;
	float x,y,sX,sY,fX,fY,dX,dY,aniX,aniY,scaleX,scaleY;
	
	Bitmap pic;
	Bitmap anotherPic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		cgs = new CustomGraphicsSurface(this);
		cgs.setOnTouchListener(this);
		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = dY = aniX = aniY = scaleX = scaleY = 0;
		pic = BitmapFactory.decodeResource(getResources(), R.drawable.graphics);
		anotherPic = BitmapFactory.decodeResource(getResources(), R.drawable.button);

		setContentView(cgs);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		cgs.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		cgs.resume();
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		//Put thread to sleep to reduce processing speed and achieve better FPS
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//X and Y for ball
		x = event.getX();
		y = event.getY();
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sY = event.getY();
			dX = dY = aniX = aniY = scaleX = scaleY = fX = fY = 0;

			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX = fX - sX;
			dY = fY - fY;
			scaleX = dX/30;
			scaleY = dY/30;
			x = y = 0;
			break;
		}
		return true;	
	}
//We put class inside a class because we still want to have access to x and y
public class CustomGraphicsSurface extends SurfaceView implements Runnable{

	SurfaceHolder holder;//Holder will tells if canvas is valid and available and lock canvas so no other threads can come
	Thread thread =  null;
	boolean isRunning = false;
	public CustomGraphicsSurface(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		holder = getHolder();
		
	}
	
	public void pause(){
		isRunning = false;
		while(true)
		{
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		thread = null;
	}
	public void resume(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning)
		{
			if(!holder.getSurface().isValid())//if surface is not valid
			{
				continue;//Unlike break, continue will still be in while loop until surface is unvalid
			}
			
			Canvas canvas = holder.lockCanvas();//No other threads can get to if it's locked
			canvas.drawRGB(02, 02, 150);
			
			if(x != 0 && y != 0)
			{
				canvas.drawBitmap(pic, x-(pic.getWidth()/2), y - (pic.getHeight()/2), null);
			}
			if(sX != 0 && sY != 0)
			{
				canvas.drawBitmap(anotherPic, sX-(anotherPic.getWidth()/2), sY - (anotherPic.getHeight()/2), null);
			}
			if(fX != 0 && fY != 0)
			{
				canvas.drawBitmap(pic, fX-(pic.getWidth()/2) - aniX, fY - (pic.getHeight()/2) - aniY, null);

				canvas.drawBitmap(anotherPic, fX-(anotherPic.getWidth()/2), fY - (anotherPic.getHeight()/2), null);
			}
			aniX += scaleX;
			aniY += scaleY;
			holder.unlockCanvasAndPost(canvas);//unlock
			
		}
	}
	
}

}
