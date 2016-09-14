package com.ale.learning.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListViewActivity extends ListActivity {
	private final String[] strList = { "Name:Ale", "Age:33", "Sex:Male" };
	ListView listView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		listView = getListView();

		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strList));
	}
}
