package com.ale.learning.datastore;

import com.ale.learning.R;
import com.ale.learning.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferencesActivity extends Activity {

	private SharedPreferences _preferences = null;
	private final static String PREFERENCES_HEADER_NAME = "main";
	private final static String PREFERENCES_FILE_NAME = "main.xml";
	private final static String PREFERENCES_FILE_PATH = "data/data";
	private final static String KEY_NAME = "name";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datastore_sharedpreferences);
		
		initializePreferences();
		
		initializeButtonEvent();
	}
	
	private void initializePreferences()
	{
		_preferences = getSharedPreferences(PREFERENCES_HEADER_NAME,MODE_PRIVATE);
	}
	
	private void initializeButtonEvent()
	{
		Button btnSave = (Button) findViewById(R.id.btnSharedPreferencesSave);
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText txtInput = (EditText) findViewById(R.id.txtSharedPreferencesNameInput);
				String inputName = txtInput.getText().toString();
				
				Editor editor = _preferences.edit();
				editor.putString(KEY_NAME, inputName);
				editor.commit();
				
				showDialog("Save Success!");
			}
		});
	}
	
	private void showDialog(String mString){
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Result");
		builder.setMessage(mString);
		builder.create().show();
	}
}
