package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
	MediaPlayer song;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//Background music
		song = MediaPlayer.create(Splash.this, R.raw.sound);
		
		//Setup music preference to turn on/off 
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if(music){
		song.start();
		}
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
					
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					//Instead of using:
					//Intent openStarting = new Intent("com.example.android.MAINACTIVITY");
					
					//We can use below code
					Intent openStarting = new Intent("com.example.android.MENU");
					startActivity(openStarting);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}

}
