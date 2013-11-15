/*Data.java and this class involve passing data back and forth between 
 * two activities by using startActivity and startActivityForResult
 */
package com.example.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OpenData extends Activity{
	EditText message;
	TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.open);
		 message = (EditText) findViewById(R.id.sendEt);
		Button start = (Button) findViewById(R.id.startActivityBt);
		Button startForResult = (Button) findViewById(R.id.safrBt);
		 result = (TextView) findViewById(R.id.gotTv);
		
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = message.getText().toString();
				Bundle board = new Bundle();
				board.putString("messageKey", text);
				Intent moveToDataClass = new Intent(OpenData.this,Data.class);
				moveToDataClass.putExtras(board);
				startActivity(moveToDataClass);
			}
		});
		
		startForResult.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(OpenData.this, Data.class);
				startActivityForResult(i, 0);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK)
		{
			Bundle bundle = data.getExtras();
			String s = bundle.getString("answerKey");
			result.setText(s);
		}
	}
	
	

}
