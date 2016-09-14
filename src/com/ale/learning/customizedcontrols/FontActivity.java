package com.ale.learning.customizedcontrols;

import com.ale.learning.R;
import com.ale.learning.R.string;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class FontActivity extends Activity{
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(new FontView(this));
		
		Display display = getWindowManager().getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
		
		super.onCreate(savedInstanceState);
	}
	
	class FontView extends View
	{
		public final static String WIDTH = "Get the string width:";
		public final static String HEIGHT = "Get the string height:";
		Paint paint = null;
		
		public FontView(Context context) {
			super(context);
			paint = new Paint();
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			paint.setColor(Color.RED);
			paint.setTextSize(18);
			
			canvas.drawText("Current screen width: " + screenWidth, 0, 30, paint);
			canvas.drawText("Current screen height: " + screenHeight, 0, 60, paint);
			
			canvas.drawText("Font size is 18", 0, 90, paint);
			
			paint.setColor(Color.YELLOW);
            canvas.drawText(getResources().getString(R.string.activity_dialog_button_label_customize), 0, 120, paint);
            super.onDraw(canvas);
		}
	}
}
