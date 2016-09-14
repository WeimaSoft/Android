package com.ale.learning.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SimpleListViewActivity extends ListActivity {
	private final String[] strList = {"Name:Ale", "Age:33","Sex:Male"};
	ListView listView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
