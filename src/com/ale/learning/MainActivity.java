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

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setUpButtonListner(R.id.btnDialogDemo, setUpClickListner(DialogActivity.class));
		
		setUpButtonListner(R.id.btnCustomizeViewDemo, setUpClickListner(CustomizeControlsActivity.class));
		
		setUpButtonListner(R.id.btnCommonControls, setUpClickListner(CommonControlsActivity.class));
		
		setUpButtonListner(R.id.btnListView, setUpClickListner(ListViewActivity.class));
	}
	
	private OnClickListener setUpClickListner(final Class<?> classRef)
	{
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, classRef);
				startActivity(intent);
			}
		};
	}
	
	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}
}
