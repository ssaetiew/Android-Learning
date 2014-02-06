package com.example.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		TabHost host = (TabHost) findViewById(R.id.tabhost);
		host.setup();
		
		TabSpec spec = host.newTabSpec("test tab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("Stop Watch");
		host.addTab(spec);
		
		spec = host.newTabSpec("test tab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Tab 2");
		host.addTab(spec);
		
		spec = host.newTabSpec("test tab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("Add a tab");
		host.addTab(spec);
	}

}
