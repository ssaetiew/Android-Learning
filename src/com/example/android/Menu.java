package com.example.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	//set up array
	String classes[] = {"MainActivity","PasswordText","example2","example3"
						,"example4","example5"};
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
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
}
