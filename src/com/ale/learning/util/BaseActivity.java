package com.ale.learning.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	protected void startNewActivityWhenButtonClick(int buttonId, final Class<?> newActivityCls) {
		Button btnFont = (Button) findViewById(buttonId);
		btnFont.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BaseActivity.this, newActivityCls);
				startActivity(intent);
			}
		});
	}
}
