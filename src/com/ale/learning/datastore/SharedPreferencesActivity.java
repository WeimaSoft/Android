package com.ale.learning.datastore;

import com.ale.learning.R;
import com.ale.learning.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SharedPreferencesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datastore_sharedpreferences);
		
		Button btnSave = (Button) findViewById(R.id.btnSharedPreferencesSave);
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
	}
}
