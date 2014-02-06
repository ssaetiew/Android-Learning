package com.example.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener{
	
	private Button btn1,btn2,btn3,btn4;
	private CheckBox chkBox;
	private SlidingDrawer drawer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		chkBox = (CheckBox) findViewById(R.id.checkBox1);
		drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		chkBox.setOnCheckedChangeListener(this);
		drawer.setOnDrawerOpenListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1:
			drawer.open();
			break;
		case R.id.button2:
			
			break;
		case R.id.button3:
			drawer.toggle();
			break;
		case R.id.button4:
			drawer.close();
			break;
		
		}
		
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.isChecked())
		{
			drawer.lock();
		}
		else
		{
			drawer.unlock();
		}
	}
	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer player = MediaPlayer.create(this, R.raw.explosion);
		player.start();
	}

}
