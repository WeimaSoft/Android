package com.ale.learning;

import android.app.Activity;
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

	private int screenWidth = 0;
	private int screenHeight = 0;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_view);
		
		Display display = getWindowManager().getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();
		
		Button btnFont = (Button) findViewById(R.id.btnDrawString);
		btnFont.setOnClickListener(fontListner);
	}
	
	private OnClickListener fontListner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FontView view = new FontView(CustomizeViewActivity.this);
		}
	};
	
	class FontView extends View
	{
		public final static String WIDTH = "Get the string width:";
		public final static String HEIGHT = "Get the string height:";
		Paint paint = null;
		
		public FontView(Context context) {
			super(context);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			paint.setColor(Color.RED);
			paint.setTextSize(18);
			
			canvas.drawText("Current screen width: " + screenWidth, 0, 30, paint);
			canvas.drawText("Current screen height: " + screenHeight, 0, 60, paint);
			
			canvas.drawText("Font size is 18", 0, 90, paint);
			
			paint.setColor(Color.YELLOW);
            canvas.drawText(getResources().getString(R.string.lblCustomize), 0, 120, paint);
            super.onDraw(canvas);
		}
	}
}
