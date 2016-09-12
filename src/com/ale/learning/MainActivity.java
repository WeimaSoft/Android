package com.ale.learning;

import java.util.ArrayList;
import java.util.Iterator;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements Runnable {

	private final String[] menuItems = { "选项1", "选项2", "选项3", "选项4" };
	private ProgressDialog dialog;
	private ArrayList<String> selectedItems = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setUpButtonListner(R.id.btnOKCancel, okCancelListner);

		setUpButtonListner(R.id.btnMultipleButtons, multiButtonsListner);

		setUpButtonListner(R.id.btnList, listListner);

		setUpButtonListner(R.id.btnSingleOption, singleOptionListner);

		setUpButtonListner(R.id.btnProgress, progressListner);

		setUpButtonListner(R.id.btnMultipleOptions, multipleOptionsListner);
		
		setUpButtonListner(R.id.btnReadProgress, readProgressListner);
	}

	public void run() {
		int progress = 0;
		while (progress < 100) {
			try {
				Thread.sleep(100);
				progress++;
				dialog.incrementProgressBy(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private OnClickListener readProgressListner = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setTitle("读取进度条示例");
			dialog.setIndeterminate(true);
			dialog.setCancelable(true);
			dialog.show();
		}
	};
	
	private OnClickListener multipleOptionsListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder= getBuilder("多项选择");
			builder.setMultiChoiceItems(menuItems, new boolean[]{false,false,false,false}, new OnMultiChoiceClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					if (isChecked) {
						selectedItems.add(menuItems[which]);
					}else
					{
						selectedItems.remove(menuItems[which]);
					}
				}
				
			});
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String mString = "您选择了：";
					for (String item : selectedItems) {
						mString += item + " ";
					}
					showDialog(mString);
				}
			});
			builder.create().show();
		}
	};

	private OnClickListener progressListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setTitle("进度条示例");
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			dialog.show();

			new Thread(MainActivity.this).start();
		}
	};

	private OnClickListener singleOptionListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("单项选择");
			builder.setSingleChoiceItems(menuItems, 0, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了第" + (which + 1) + "项,值为" + menuItems[which]);
				}
			});
			builder.create().show();
		}
	};

	private OnClickListener listListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("请选择列表项");
			builder.setItems(menuItems, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("你选择了第" + (which + 1) + "项,值为" + menuItems[which]);
				}
			});
			builder.create().show();
		}

	};

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
			AlertDialog.Builder builder = getBuilder("你确定要离开吗？");
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

	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}

	private void showDialog(String title) {
		getBuilder(title).show();
	}

	private Builder getBuilder(String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle(title);
		return builder;
	}
}
