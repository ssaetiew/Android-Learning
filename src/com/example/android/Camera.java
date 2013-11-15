/*
 * Take picture, then set it as background (Require permission)
 */
package com.example.android;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{
	
	ImageView imgView;
	ImageButton imgButton;
	Button setWallButton;
	Intent camera;
	final static int cameraData = 0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initializeVar();
		
		//Initialize background image
		InputStream initImg = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(initImg);
	}

	private void initializeVar() {
		imgView = (ImageView) findViewById(R.id.ivReturnPic);
		imgButton = (ImageButton) findViewById(R.id.ibTakePic);
		setWallButton = (Button) findViewById(R.id.bSetWallPaper);	
		setWallButton.setOnClickListener(this);
		imgButton.setOnClickListener(this);
	}
	

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.ibTakePic:
			camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			try {
				WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext());
				wpm.setBitmap(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Start activity which we'll get result back. Assign it to cameraData
			startActivityForResult(camera,cameraData);
			break;
		case R.id.bSetWallPaper:
			break;
		
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		//If everything is ok and we get result back
		if(resultCode == RESULT_OK)
		{
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			imgView.setImageBitmap(bmp);
			
		}
	}
	

}
