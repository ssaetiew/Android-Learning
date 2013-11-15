package com.example.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Random;
public class PasswordText extends Activity implements View.OnClickListener{
	Button chkCmd;
	ToggleButton toggle;
	EditText passwordField;
	TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		declareWidget();
	
		//Set up Toggle button
		toggle.setOnClickListener(this);
		chkCmd.setOnClickListener(this);
	}//Close onCreate

	private void declareWidget() {
		
		//Assign widget to variable
				chkCmd = (Button) findViewById(R.id.bResult);
				toggle = (ToggleButton) findViewById(R.id.togButton);
				passwordField = (EditText) findViewById(R.id.password);
				text = (TextView) findViewById(R.id.tvResult);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId())
		{
		case R.id.bResult:
			String check = passwordField.getText().toString();
			text.setText(check);
			
			//Playing with gravity and color settings
			check = check.toLowerCase();
			if(check.contentEquals("left"))
			{
				text.setGravity(Gravity.LEFT);
			}
			else if(check.contentEquals("center"))
			{
				text.setGravity(Gravity.CENTER);
			}
			else if(check.contentEquals("right"))
			{
				text.setGravity(Gravity.RIGHT);
			}
			else if(check.equals("blue"))
			{
				text.setTextColor(Color.BLUE);
			}
			else if(check.contains("rand"))
			{
				Random rand = new Random();
				text.setText("RANDOM!!");
				text.setTextSize(rand.nextInt(75));
				text.setTextColor(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
				
				switch(rand.nextInt(3))
				{
				case 0:
					text.setGravity(Gravity.LEFT);
					break;
				case 1:
					text.setGravity(Gravity.CENTER);
					break;
				case 2:
					text.setGravity(Gravity.RIGHT);
					break;
				
				}
			}
			else
			{
				text.setText("Invalid");
				text.setGravity(Gravity.CENTER);
				text.setTextColor(Color.WHITE);
			}
		break;
		case R.id.togButton:
			if(toggle.isChecked())
			{
				passwordField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			else
			{
				passwordField.setInputType(InputType.TYPE_CLASS_TEXT);
			}
		break;
			
		}
	}

}
