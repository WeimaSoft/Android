package com.ale.learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomizeViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_view);

		startNewActivityWhenButtonClick(R.id.btnDrawString, FontActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnDrawUnRule, UnRuleActivity.class);
	}

	private void startNewActivityWhenButtonClick(int buttonId, final Class<?> newActivityCls) {
		Button btnFont = (Button) findViewById(buttonId);
		btnFont.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CustomizeViewActivity.this, newActivityCls);
				startActivity(intent);
			}
		});
	}
}
