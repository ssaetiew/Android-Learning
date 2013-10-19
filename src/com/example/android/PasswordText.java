package com.example.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class PasswordText extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		//Assign widget to variable
		Button chkCmd = (Button) findViewById(R.id.bResult);
		ToggleButton toggle = (ToggleButton) findViewById(R.id.togButton);
		EditText passwordField = (EditText) findViewById(R.id.password);
		TextView text = (TextView) findViewById(R.id.tvResult);
	}

}
