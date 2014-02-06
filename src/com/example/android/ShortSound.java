package com.example.android;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class ShortSound extends Activity implements OnClickListener, OnLongClickListener {
	
	SoundPool sound;
	private int explosion = 0;
	MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		
		setContentView(v);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(explosion != 0)
		{
		sound.play(explosion,1,1,0,0,1);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(sound == null)
		{
		sound = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		
		explosion = sound.load(this, R.raw.explosion, 1);
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		}
		player = MediaPlayer.create(this, R.raw.backgroundmusic);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		sound.release();
		sound = null;
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		player.start();
		return false;
	}
	

}
