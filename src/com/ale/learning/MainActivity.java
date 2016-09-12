package com.ale.learning;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnOKCancel = (Button) findViewById(R.id.btnOKCancel);
		btnOKCancel.setOnClickListener(okCancelListner);

		Button btnMultiBtns = (Button) findViewById(R.id.btnMultipleButtons);
		btnMultiBtns.setOnClickListener(multiButtonsListner);
	}

	private OnClickListener multiButtonsListner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("你确定要离开吗？");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了确定");

				}
			});

			builder.setNeutralButton("其实我也不知道", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("没想到你也不知道");

				}
			});

			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了取消");

				}
			});
			builder.create().show();
		}
	};

	private OnClickListener okCancelListner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("你确定要离开吗？");
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了确定");

				}
			});

			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了取消");

				}
			});
			builder.create().show();
		}

	};

	private void showDialog(String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle(title);
		builder.show();
	}
}
