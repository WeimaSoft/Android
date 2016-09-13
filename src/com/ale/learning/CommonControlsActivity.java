package com.ale.learning;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CommonControlsActivity extends Activity {

	private static LinearLayout layout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_controls);

		layout = (LinearLayout) findViewById(R.id.commonControlsLayout);

		addTextView();

		addWebView();

		addEditText();

		addRadioGroup();

		addCheckBox();
	}

	private void addCheckBox() {
		CheckBox cb1 = new CheckBox(this);
		cb1.setText("Check Item One");

		layout.addView(cb1);
		CheckBox cb2 = new CheckBox(this);
		cb2.setText("Check Item One");

		layout.addView(cb2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Menu One");
		menu.add("Menu Two");
		menu.add("Menu Thr");
		menu.add("Menu Fou");
		menu.add("Menu Fiv");

		return super.onCreateOptionsMenu(menu);
	}

	private void addRadioGroup() {
		RadioGroup radioGroup = new RadioGroup(this);

		RadioButton radioButton1 = new RadioButton(this);
		radioButton1.setText("Item One");
		radioGroup.addView(radioButton1);

		RadioButton radioButton2 = new RadioButton(this);
		radioButton2.setText("Item Two");
		radioGroup.addView(radioButton2);

		layout.addView(radioGroup);
	}

	private void addEditText() {
		EditText editText = new EditText(this);
		editText.setHint("Please enter your phone number");
		editText.setInputType(InputType.TYPE_CLASS_PHONE);

		layout.addView(editText);
	}

	private void addWebView() {
		WebView webView = new WebView(this);
		webView.loadDataWithBaseURL(null, "<a href='http://www.sohu.com'>Welcome to Sohu</a>", "text/html", "UTF8",
				null);

		layout.addView(webView);
	}

	private void addTextView() {
		TextView textView = new TextView(this);
		textView.setTextSize(22);
		textView.setText("This is a TextView");

		layout.addView(textView);
	}
}
