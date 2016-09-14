package com.ale.learning;

import com.ale.learning.customizedcontrols.DrawPictureActivity;
import com.ale.learning.customizedcontrols.FontActivity;
import com.ale.learning.customizedcontrols.PlayActivity;
import com.ale.learning.customizedcontrols.UnRuleActivity;

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

public class CustomizeControlsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_controls);

		startNewActivityWhenButtonClick(R.id.btnDrawString, FontActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnDrawUnRule, UnRuleActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnDrawPicture, DrawPictureActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnPlay, PlayActivity.class);
	}

	private void startNewActivityWhenButtonClick(int buttonId, final Class<?> newActivityCls) {
		Button btnFont = (Button) findViewById(buttonId);
		btnFont.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CustomizeControlsActivity.this, newActivityCls);
				startActivity(intent);
			}
		});
	}
}
