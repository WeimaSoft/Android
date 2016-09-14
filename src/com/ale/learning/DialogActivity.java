package com.ale.learning;

import java.util.ArrayList;
import java.util.Iterator;

import android.R.bool;
import android.R.string;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends Activity implements Runnable {

	private final String[] menuItems = { "Menu Item 1", "Menu Item 2", "Menu Item 3", "Menu Item 4" };
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

		setUpButtonListner(R.id.btnCustomize, customizeListner);
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

	private OnClickListener customizeListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Customized Dialog");
			LayoutInflater fac = LayoutInflater.from(DialogActivity.this);
			final View dialogView = fac.inflate(R.layout.customize_layout, null);
			builder.setView(dialogView);
			setUpButtons(builder, false);
		}

	};

	private OnClickListener readProgressListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			dialog = new ProgressDialog(DialogActivity.this);
			dialog.setTitle("Dialog Progress");
			dialog.setIndeterminate(true);
			dialog.setCancelable(true);
			dialog.show();
		}
	};

	private OnClickListener multipleOptionsListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Dialog Multiple Options");
			builder.setMultiChoiceItems(menuItems, new boolean[] { false, false, false, false },
					new OnMultiChoiceClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					if (isChecked) {
						selectedItems.add(menuItems[which]);
					} else {
						selectedItems.remove(menuItems[which]);
					}
				}

			});
			setUpButtons(builder, false);
		}
	};

	private OnClickListener progressListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			dialog = new ProgressDialog(DialogActivity.this);
			dialog.setTitle("Dialog Progress");
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			dialog.show();

			new Thread(DialogActivity.this).start();
		}
	};

	private OnClickListener singleOptionListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Dialog Single Option");
			builder.setSingleChoiceItems(menuItems, 0, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("You select item " + (which + 1) + " the value is " + menuItems[which]);
				}
			});

			builder.create().show();
		}
	};

	private OnClickListener listListner = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Dialog List");
			builder.setItems(menuItems, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("You select item " + (which + 1) + " the value is " + menuItems[which]);
				}
			});
			builder.create().show();
		}

	};

	private OnClickListener multiButtonsListner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Dialog Multiple Buttons");
			setUpButtons(builder, true);
		}
	};

	private OnClickListener okCancelListner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = getBuilder("Dialog OK Cancel");
			setUpButtons(builder, false);
		}
	};

	private void setUpButtons(Builder builder, Boolean addNeturalBtn) {
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showDialog("You select Yes");

			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showDialog("You select No");

			}
		});

		if (addNeturalBtn) {
			builder.setNeutralButton("Netural", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					showDialog("You select Netural");

				}
			});
		}
		builder.create().show();
	}

	private void setUpButtonListner(int buttonId, OnClickListener listner) {
		Button btnList = (Button) findViewById(buttonId);
		btnList.setOnClickListener(listner);
	}

	private void showDialog(String title) {
		getBuilder(title).show();
	}

	private Builder getBuilder(String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
		builder.setTitle(title);
		return builder;
	}
}
