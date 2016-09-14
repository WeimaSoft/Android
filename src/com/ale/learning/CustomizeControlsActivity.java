package com.ale.learning;

import com.ale.learning.customizedcontrols.DrawPictureActivity;
import com.ale.learning.customizedcontrols.FontActivity;
import com.ale.learning.customizedcontrols.PlayActivity;
import com.ale.learning.customizedcontrols.UnRuleActivity;
import com.ale.learning.util.BaseActivity;

import android.os.Bundle;

public class CustomizeControlsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_controls);

		startNewActivityWhenButtonClick(R.id.btnCustomizedControlsDrawString, FontActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnCustomizedControlsDrawUnRule, UnRuleActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnCustomizedControlsDrawPicture, DrawPictureActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnCustomizedControlsPlay, PlayActivity.class);
	}
}
