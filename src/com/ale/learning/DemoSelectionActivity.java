package com.ale.learning;

import android.app.Activity;
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
		
		setUpButtonListner(R.id.btnDialogDemo, dialogDemoListner);
	}
	
	private OnClickListener dialogDemoListner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(DemoSelectionActivity.this, MainActivity.class);
			startActivity(intent);
		}
	};
	
	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}
}
