package com.ale.learning;

import com.ale.learning.datastore.SharedPreferencesActivity;
import com.ale.learning.util.BaseActivity;

import android.os.Bundle;

public class DataStoreActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datastore);
		
		startNewActivityWhenButtonClick(R.id.btnDataStoreSharedPreferences,SharedPreferencesActivity.class);
	}
}
