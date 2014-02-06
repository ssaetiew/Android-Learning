package com.example.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	//set up array
	String classes[] = {"MainActivity","PasswordText","Email","Camera"
						,"OpenData","Graphics", "GraphicsSurface", "ShortSound", "Slider", "Tabs"};
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub	
		super.onListItemClick(l, v, position, id);
		
		String classesName = classes[position];
		
		//Start Activity need intent 2 ways to do it: 1) Use action name in Manifest file
		//2) set up Class with the path name of that class
		try{//need to use try because we cannot have invalid string of name
		Class ourClass = Class.forName("com.example.android."+classesName);
		Intent ourIntent = new Intent(Menu.this,ourClass);
		startActivity(ourIntent);
		}
		catch(ClassNotFoundException e){
		e.printStackTrace();	
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Request to make fullscreen to OS
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Set windows screen to be fullscreen (CAREFUL: it will hide the menu we setup below)
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.aboutUs:
				Intent intent = new Intent("com.example.android.ABOUT");
				startActivity(intent);
			break;
		case R.id.preferences:
			Intent pref = new Intent("com.example.android.PREFS");
			startActivity(pref);
			break;
		
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}
	
}
