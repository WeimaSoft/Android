package com.ale.learning.customizedcontrols;

import com.ale.learning.R;
import com.ale.learning.R.drawable;
import com.ale.learning.R.id;
import com.ale.learning.R.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DrawPictureActivity extends Activity {

	private ImageViewAle imageView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customizedcontrols_draw_picture);

		imageView = new ImageViewAle(this);
		LinearLayout layout = (LinearLayout) findViewById(R.id.imageLayout);
		layout.addView(imageView);

		Button botton0 = (Button) findViewById(R.id.buttonLeft);
		botton0.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				imageView.move2Left();
			}
		});

		Button botton1 = (Button) findViewById(R.id.buttonRight);
		botton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				imageView.move2Right();
			}
		});
		Button botton2 = (Button) findViewById(R.id.buttonRotationLeft);
		botton2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				imageView.turnLeft();
			}
		});

		Button botton3 = (Button) findViewById(R.id.buttonRotationRight);
		botton3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				imageView.turnRight();
			}
		});

		Button botton4 = (Button) findViewById(R.id.buttonNarrow);
		botton4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				imageView.minSize();
			}
		});

		Button botton5 = (Button) findViewById(R.id.buttonEnlarge);
		botton5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				imageView.maxSize();
			}
		});
	}

	class ImageViewAle extends View {
		Paint paint = null;
		Bitmap bitmap = null;
		Bitmap bitmap2Display = null;
		int posX = 120;
		int posY = 50;
		int bitmapwidth = 0;
		int bitmapheight = 0;
		Matrix matrix = null;
		float angle = 0f;
		float scale = 1;

		public ImageViewAle(Context context) {
			super(context);
			paint = new Paint();
			paint.setFlags(Paint.ANTI_ALIAS_FLAG);
			bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.demo);
			bitmap2Display = bitmap;
			matrix = new Matrix();
			bitmapwidth = bitmap.getWidth();
			bitmapheight = bitmap.getHeight();
		}

		public void move2Left() {
			posX -= 10;
		}

		public void move2Right() {
			posX += 10;
		}

		public void turnLeft() {
			angle--;
			setAngle();
		}

		public void turnRight() {
			angle++;
			setAngle();
		}

		public void minSize() {
			scale -= 0.1;
			setScale();
		}

		public void maxSize() {
			scale += 0.1;
			setScale();
		}

		public void setAngle() {
			matrix.reset();
			matrix.setRotate(angle);
			bitmap2Display = Bitmap.createBitmap(bitmap, 0, 0, bitmapwidth, bitmapheight, matrix, true);
		}

		public void setScale() {
			matrix.reset();
			matrix.postScale(scale, scale);
			bitmap2Display = Bitmap.createBitmap(bitmap, 0, 0, bitmapwidth, bitmapheight, matrix, true);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawBitmap(bitmap2Display, posX, posY, paint);
			invalidate();
		}
	}
}
