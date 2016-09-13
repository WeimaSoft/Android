package com.ale.learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DemoSelectionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_selection);
		
		setUpButtonListner(R.id.btnDialogDemo, setUpClickListner(MainActivity.class));
		
		setUpButtonListner(R.id.btnCustomizeViewDemo, setUpClickListner(CustomizeViewActivity.class));
		
		setUpButtonListner(R.id.btnCommonControls, setUpClickListner(CommonControlsActivity.class));
	}
	
	private OnClickListener setUpClickListner(final Class<?> classRef)
	{
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoSelectionActivity.this, classRef);
				startActivity(intent);
			}
		};
	}
	
	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}
}
