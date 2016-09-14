package com.ale.learning;

import com.ale.learning.listview.CustomizeBaseAdapterActivity;
import com.ale.learning.listview.HeaderListViewActivity;
import com.ale.learning.listview.SimpleListViewActivity;
import com.ale.learning.util.BaseActivity;

import android.os.Bundle;

public class ListViewActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		startNewActivityWhenButtonClick(R.id.btnlistviewSimple, SimpleListViewActivity.class);

		startNewActivityWhenButtonClick(R.id.btnlistviewHeader, HeaderListViewActivity.class);

		startNewActivityWhenButtonClick(R.id.btnlistviewBaseAdapter, CustomizeBaseAdapterActivity.class);
	}
}
