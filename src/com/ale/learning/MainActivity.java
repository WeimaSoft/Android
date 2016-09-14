package com.ale.learning;

import com.ale.learning.util.BaseActivity;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startNewActivityWhenButtonClick(R.id.btnmainDialogDemo, DialogActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnmainCustomizeViewDemo, CustomizeControlsActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnmainCommonControls, CommonControlsActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnmainListView, ListViewActivity.class);
		
		startNewActivityWhenButtonClick(R.id.btnmainDataStore, DataStoreActivity.class);
		
	}
}
