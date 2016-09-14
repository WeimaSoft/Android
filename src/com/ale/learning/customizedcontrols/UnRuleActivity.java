package com.ale.learning.customizedcontrols;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

public class UnRuleActivity extends Activity {
	private int screenWidth = 0;
	private int screenHeight = 0;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(new UnRuleView(this));

		Display display = getWindowManager().getDefaultDisplay();
		screenWidth = display.getWidth();
		screenHeight = display.getHeight();

		super.onCreate(savedInstanceState);
	}

	class UnRuleView extends View {
		Paint paint = null;

		@SuppressWarnings("static-access")
		public UnRuleView(Context context) {
			super(context);
			paint = new Paint();
			paint.setFlags(paint.ANTI_ALIAS_FLAG);
		}

		@SuppressLint({ "NewApi", "DrawAllocation" })
		@Override
		protected void onDraw(Canvas canvas) {
			paint.setColor(Color.RED);
			paint.setTextSize(18);

			canvas.drawText("Current screen width: " + screenWidth, 0, 30, paint);
			canvas.drawText("Current screen height: " + screenHeight, 0, 60, paint);

			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(2);
			canvas.drawLine(0, 90, screenWidth * 2 / 3, 90, paint);	
			
			paint.setColor(Color.YELLOW);
			canvas.drawRect(10, 120, screenWidth * 3 /4, 130, paint);
			
			paint.setColor(Color.RED);
			canvas.drawCircle(50, 150, 30, paint);
			
			paint.setColor(Color.BLUE);
			canvas.drawOval(new RectF(50,250,180,400), paint);
			
			paint.setColor(Color.BLACK);
			Path path = new Path();
			path.moveTo(70, 300);
			path.lineTo(120, 300);
			path.lineTo(120, 100);
			path.lineTo(150, 180);
			canvas.drawPath(path, paint);
			
			super.onDraw(canvas);
		}
	}
}
