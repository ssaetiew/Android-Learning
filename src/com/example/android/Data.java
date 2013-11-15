/*OpenData.java and this class involve passing data back and forth between 
 * two activities by using startActivity and startActivityForResult
 */
package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Data extends Activity implements OnCheckedChangeListener {
	String text = "", setData = "";
	RadioGroup selection;
	TextView test,title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play);

		 title = (TextView) findViewById(R.id.textView1);
		Button enter = (Button) findViewById(R.id.returnBt);
		 test = (TextView) findViewById(R.id.testTv);
		selection = (RadioGroup) findViewById(R.id.radioGroup1);
		enter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("answerKey", setData);
				intent.putExtras(bundle);
				setResult(RESULT_OK,intent);
				finish();
			}
		});
		selection.setOnCheckedChangeListener(this);
		
		//Setup Preferences
		SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String editText = getPref.getString("name","SK is...");
		String value = getPref.getString("list", "4");
		if(value.contentEquals("1")){
			title.setText(editText);
		}
		
		
		//Uncomment below if you just want to test for startActivity
		//Bundle gotBoard = getIntent().getExtras();
		//text = gotBoard.getString("messageKey");
		//title.setText(text);
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.radio0:
			setData = "Maybe...";
			break;
		case R.id.radio1:
			setData = "Coool...";
			break;
		case R.id.radio2:
			setData = "The BOSS...";
			break;
		}
		test.setText(setData);

	}

}
