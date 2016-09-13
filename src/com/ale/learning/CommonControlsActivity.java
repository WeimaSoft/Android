package com.ale.learning;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommonControlsActivity extends Activity {

	private static LinearLayout layout = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_controls);
		
		layout = (LinearLayout) findViewById(R.id.commonControlsLayout);
		
		addTextView();
	}
	
	private void addTextView()
	{
		TextView textView = new TextView(this);
		textView.setTextSize(22);
		textView.setText("This is a TextView");
		
		layout.addView(textView);
	}
}
