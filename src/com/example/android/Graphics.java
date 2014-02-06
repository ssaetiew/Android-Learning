/*This class and CustomGraphics class will be about setting up animation 
 * and graphics. However, this class is used a lot of computing power
 */
package com.example.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.WindowManager.LayoutParams;

public class Graphics extends Activity{
	
	WakeLock awake;
	CustomGraphics customView; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//Setup WakeLock
		/*PowerManager power = (PowerManager)getSystemService(Context.POWER_SERVICE);
		awake = power.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Just testing");*/
	

		super.onCreate(savedInstanceState);
		//New way for wakeLock
		getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		customView = new CustomGraphics(this);
		setContentView(customView);
	}
	
	
	

}
